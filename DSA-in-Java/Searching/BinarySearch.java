package Searching;

public class BinarySearch {

    // Binary Search Iterative
    // Time - O(logN), Space - O(1)
    static int binarySearchIterative(int[] arr, int target) {
        int n = arr.length;
        int low = 0;
        int high = n-1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == target) return mid;
            else if (target > arr[mid]) low = mid + 1;
            else high = mid-1;
        }
        return -1;
    }

    // Binary Search Recursive
    static int binarySearchRecursive(int[] arr, int target) {
        int n = arr.length;
        int low = 0;
        int high = n-1;
        return binarySearchFunction(arr, low, high, target);
    }

    // Binary Search Recursive Function
    static int binarySearchFunction(int[] arr, int low, int high, int target) {
        int n = arr.length;

        if (low > high) return -1;

        int mid = low + (high - low) / 2;
        if (arr[mid] == target) return mid;
        else if (target > arr[mid]) return binarySearchFunction(arr,mid+1, high, target);
        else return binarySearchFunction(arr, low, mid-1, target);
    }

    // Main Function
    public static void main(String[] args) {
        int[] a = {3, 4, 6, 7, 9, 12, 16, 17};
        int target = 6;
//        int idx1 = binarySearchIterative(a, target);
        int idx2 = binarySearchRecursive(a, target);
        if (idx2 == -1)
            System.out.println("The target is not present.");
        else
            System.out.println("The target is at index: " + idx2);
    }
}

// Output -
// The target is at index: 2

// Algorithm - Binary Search Iterative
/*
1. Step 1: Divide the search space into 2 halves:
In order to divide the search space, we need to find the middle point of it. So, we will take a ‘mid’ pointer and do the following:
    1. mid = (low+high) // 2 ( ‘//’ refers to integer division)
2. Step 2: Compare the middle element with the target:
In this step, we can observe 3 different cases:
    1. If arr[mid] == target: We have found the target. From this step, we can return the index of the target possibly.
    2. If target > arr[mid]: This case signifies our target is located on the right half of the array. So, the next search space will be the right half.
    3. If target < arr[mid]: This case signifies our target is located on the left half of the array. So, the next search space will be the left half.
3. Step 3: Trim down the search space:
Based on the probable location of the target we will trim down the search space.
    1. If the target occurs on the left, we should set the high pointer to mid-1. Thus the left half will be the next search space.
    2. Similarly, if the target occurs on the right, we should set the low pointer to mid+1. Thus the right half will be the next search space.
 */

// Algorithm - Binary Search Recursive
/*
1. Step 1: Divide the search space into 2 halves:
In order to divide the search space, we need to find the middle point of it. So, we will take a ‘mid’ pointer and do the following:
    1. mid = (low+high) // 2 ( ‘//’ refers to integer division)
2. Step 2: Compare the middle element with the target and trim down the search space:
In this step, we can observe 3 different cases:
    1. If arr[mid] == target: We have found the target. From this step, we can return the index of the target, and the recursion will end.
    2. If target > arr[mid]: This case signifies our target is located on the right half of the array. So, the next recursion call will be binarySearch(nums, mid+1, high).
    3. If target < arr[mid]: This case signifies our target is located on the left half of the array. So, the next recursion call will be binarySearch(nums, low, mid-1).
3. Base case: The base case of the recursion will be low > high. If (low > high), the search space becomes invalid which means the target is not present in the array.
 */

// Time & Space Complexity
/*
Time Complexity:
Best Case: O(1)
Average Case: O(log N)
Worst Case: O(log N)

Auxiliary Space: O(1), If the recursive call stack is considered then the auxiliary space will be O(logN).
 */