package BinarySearch;

public class Find_First_Occurrence {

    // Method 1 : Brute Force
    // Time : O(N), Space - O(1)
//    static int findFirstOccurrence(int[] arr, int target) {
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
    // Time : O(log2N), Space - O(1)
    static int findFirstOccurrence(int[] arr, int target) {
        int n = arr.length;

        int low = 0;
        int high = n-1;
        int ans = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == target) {
                ans = mid;
                high = mid-1;
            }
            else if (target > arr[mid]) {
                low = mid+1;
            }
            else {
                high = mid-1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int target = 13;
        int[] arr = {3,4,13,13,13,13,13,20,40};
        int res = findFirstOccurrence(arr, target);
        System.out.println(res);
    }
}

// Output -
// 2

// Algorithm : Brute Force
/*
1. As the array is already sorted, start traversing the array using a for loop and check whether the
element is present or not.
2. If the target element is present, break out of the loop and print the resulting index.
3. If the target element is not present inside the array, then print -1
 */

// Algorithm : Optimal Solution
/*
1. Initialize low = 0 and high = n-1, ans = -1
2. Run a loop until low <= high
3. Find mid = low + (high - low) / 2
4. If the mid element is equal to the key value, store the mid-value in the result and move the high pointer to mid-1(move leftward)
5. Else if the key value is less than the mid element then low = mid+1(move leftward)
6. Else do high = mid-1 (move leftwards)
 */

// Striver Video Explanation : https://www.youtube.com/watch?v=hjR1IYVx9lY