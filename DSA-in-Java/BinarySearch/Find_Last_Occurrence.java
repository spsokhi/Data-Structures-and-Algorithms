package BinarySearch;

public class Find_Last_Occurrence {

    // Method 1 : Brute Force
    // Time - O(N), Space - O(1)
//    static int findLastOccurrence(int[] arr, int target) {
//        int n = arr.length;
//        int res = -1;
//
//        for (int i=n-1; i>=0; i--) {
//            if (arr[i] == target) {
//                res = i;
//                break;
//            }
//        }
//        return res;
//    }

    // Method 2 : Optimal Solution
    // Time : O(log2N), Space : O(1)
    static int findLastOccurrence1(int[] arr, int target) {
        int n = arr.length;

        int low = 0;
        int high = n-1;
        int ans = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == target) {
                ans = mid;
                low = mid+1;
            }
            else if (target < arr[mid]) {
                high = mid-1;
            }
            else {
                low = mid+1;
            }
        }
        return ans;
    }

    // Main Function
    public static void main(String[] args) {
        int target = 13;
        int[] arr = {3,4,13,13,13,13,13,20,40};
        int res = findLastOccurrence1(arr, target);
        System.out.println(res);
    }
}

// Output -
// 6

// Algorithm : Brute Force
/*
1. As the array is already sorted, start traversing the array from the back using a for loop and check whether the
element is present or not.
2. If the target element is present, break out of the loop and print the resulting index.
3. If the target element is not present inside the array, then print -1
 */

// Algorithm : Optimal Solution
/*
1. 1. Initialize low = 0, high = n-1, ans = -1
2. Run a loop until low <= high
3. Find mid = low + (high - low) / 2
4. If the mid element is equal to the key value, store the mid-value in the result and move the low pointer to mid+1(move leftward)
5. Else if the key value is less than the mid element then high = mid-1(move leftward)
6. Else do low = mid+1 (move rightwards)
 */

// Striver Video Explanation : https://www.youtube.com/watch?v=hjR1IYVx9lY