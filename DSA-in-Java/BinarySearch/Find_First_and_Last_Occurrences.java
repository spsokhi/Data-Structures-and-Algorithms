package BinarySearch;

public class Find_First_and_Last_Occurrences {

    // Method 1 : Brute Force
    // Time - O(N), Space - O(1)
//    static int[] findFirstAndLast(int[] arr, int n, int target) {
//        int first = -1;
//        int last = -1;
//
//        for (int i=0; i<n; i++) {
//            if (arr[i] == target) {
//                if (first == -1) first = i;
//                last = i;
//            }
//        }
//        return new int[] {first, last};
//    }

    // Lower Bound Implementation
    // Method : Optimal Solution
    // Time - O(log2N), Space - O(1)
    static int lowerBound(int[] arr, int n, int target) {
        int low = 0;
        int high = n-1;
        int ans = n;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] >= target) {
                ans = mid;
                high = mid-1;
            }
            else low = mid + 1;
        }
        return ans;
    }

    // Upper Bound Implementation
    // Method : Optimal Solution
    // Time - O(log2N), Space - O(1)
    static int upperBound(int[] arr, int n, int target) {
        int low = 0;
        int high = n-1;
        int ans = n;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] > target) {
                ans = mid;
                high = mid - 1;
            }
            else {
                low = mid+1;
            }
        }
        return ans;
    }

    // Method 2 : Optimal Solution
    // time - 2 * O(log2N), Space - O(1)
    static int[] findFirstAndLast(int[] arr, int n, int target) {
        int lb = lowerBound(arr, n, target);
        // lb == n (hypothetical situation - means element is not present)
        // arr[lb] != target (value at this index is not equal to target)
        if (lb == n || arr[lb] != target) return new int[]{-1, -1};
        return new int[]{lb, 1 - upperBound(arr, n, target)};
    }

    // Main Function
    public static void main(String[] args) {
        int[] arr =  {2, 4, 6, 8, 8, 8, 11, 13};
        int n = 8, x = 8;
        int[] ans = findFirstAndLast(arr, n, x);
        System.out.println("The number of occurrences is: " + ans);
    }
}

// Output -
// The number of occurrences is: [3, 5]

// Algorithm : Brute Force
/*
1. Initialize first = -1 and last = -1
2. Run a loop from i=0 to n-1
3. If target == arr[i], then first = i, else last = i
4. Return first and last
 */

// Algorithm : Optimal Solution
/*
1. Implement lowerBound and upperBound functions
2. Find the lower bound of the target
3. If lower bound is equal to n or arr[lb] != target, then return [-1, -1]
          [14]                          [10]
4. Else return [lb, ub-1]
 */

// Striver Video Explanation : https://www.youtube.com/watch?v=hjR1IYVx9lY