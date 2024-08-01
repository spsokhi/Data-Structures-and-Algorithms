package BinarySearch;

public class Search_in_Rotated_Sorted_Array_II {

    // Method 1 : Brute Force
    // Time - O(N), Space - O(1)
//    static int search(int[] arr, int target) {
//        int n = arr.length;
//
//        for (int i=0; i<n; i++) {
//            if (arr[i] == target) {
//                return i;
//            }
//        }
//        return -1;
//    }

    // Method 2 : Optimal Solution
    // Time - O(log2N), Space - O(1)
    static boolean search(int[] arr, int target) {
        int n = arr.length;

        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == target) return true;

            // [3,1,2,3,3,3,3]
            if (arr[low] == arr[mid] && arr[mid] == arr[high]) {
                low++;
                high--;
                continue;
            }

            // Left part is sorted
            if (arr[low] <= arr[mid]) {
                // Check if target lies in the left part
                if (arr[low] <= target && target <= arr[mid]) {
                    // If yes, then search in the left part
                    high = mid - 1;
                }
                // If not, then search in the right part
                else {
                    low = mid + 1;
                }
            }
            // Right part is sorted
            else {
                // Check if target lies in the right part
                if (arr[mid] <= target && target <= arr[high]) {
                    // If yes, then search in the right part
                    low = mid + 1;
                }
                // If not, then search in the left part
                else {
                    high = mid - 1;
                }
            }
        }
        // If element is not found
        return false;
    }

    // Main Function
    public static void main(String[] args) {
        // edge case : {3, 1, 2, 3, 3, 3, 3}
        int[] arr = {7, 8, 1, 2, 3, 3, 3, 4, 5, 6};
        int k = 3;
        boolean ans = search(arr, k);
        if (!ans)
            System.out.println("Target is not present.");
        else
            System.out.println("Target is present in the array.");
    }
}

// Output
// 4

// Algorithm : Brute Force
// Simple Linear Search

// Algorithm : Optimal Solution
/*
Idea -  The idea is to trim the search space
if (arr[low] == arr[mid] && arr[mid] == arr[high])
In this case we move the low pointer and high pointer by +1 & -1 until we will not identify the sorted part

1. Place the 2 pointers i.e. low and high: Initially, we will place the pointers like this: low will point to the
first index, and high will point to the last index.
2. Calculate the ‘mid’: Now, inside a loop, we will calculate the value of ‘mid’ using the following formula:
    mid = (low+high) // 2 ( ‘//’ refers to integer division)
3. Check if arr[mid] == target: If it is, return the index mid.
4. Check if arr[low] = arr[mid] = arr[high]: If this condition is satisfied, we will just increment the low pointer
 and decrement the high pointer by one step. We will not perform the later steps until this condition is no
 longer satisfied. So, we will continue to the next iteration from this step.
5. Identify the sorted half, check where the target is located, and then eliminate one half accordingly:
    1. If arr[low] <= arr[mid]: This condition ensures that the left part is sorted.
        1. If arr[low] <= target && target <= arr[mid]: It signifies that the target is in this sorted half.
        So, we will eliminate the right half (high = mid-1).
        2. Otherwise, the target does not exist in the sorted half. So, we will eliminate this left half by doing low = mid+1.
    2. Otherwise, if the right half is sorted:
        1. If arr[mid] <= target && target <= arr[high]: It signifies that the target is in this sorted right half.
        So, we will eliminate the left half (low = mid+1).
        2. Otherwise, the target does not exist in this sorted half. So, we will eliminate this right half by doing high = mid-1.
6. Once, the ‘mid’ points to the target, the index will be returned.
7. This process will be inside a loop and the loop will continue until low crosses high. If no index is found, we will return -1.
 */