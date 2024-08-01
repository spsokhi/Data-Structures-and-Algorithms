package BinarySearch;

public class Count_Occurrences_in_Sorted_Array {

    // Method 1 : Brute Force
    // Time - O(N), Space - O(1)
//    static int count(int[] arr, int target) {
//        int n = arr.length;
//        int count = 0;
//
//        for (int i=0; i<n; i++) {
//            if (arr[i] == target) {
//                count++;
//            }
//        }
//        return count;
//    }

//    static int count(int[] arr, int target) {
//
//    }

    // Method 2 : Optimal Solution
    // Time - O(log2N), Space - O(1) (Overall Time Complexity - (First and Last Occurrence & Count Occurrences))

    // Find First Occurrence Function
    // Method : Optimal Solution
    // Time : O(log2N), Space - O(1)
    static int findFirstOccurrence(int[] arr, int target) {
        int n = arr.length;

        int low = 0;
        int high = n-1;
        int first = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == target) {
                first = mid;
                high = mid-1;
            }
            else if (target > arr[mid]) {
                low = mid+1;
            }
            else {
                high = mid-1;
            }
        }
        return first;
    }

    // Find Last Occurrence Function
    // Method : Optimal Solution
    // Time : O(log2N), Space : O(1)
    static int findLastOccurrence1(int[] arr, int target) {
        int n = arr.length;

        int low = 0;
        int high = n-1;
        int last = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == target) {
                last = mid;
                low = mid+1;
            }
            else if (target < arr[mid]) {
                high = mid-1;
            }
            else {
                low = mid+1;
            }
        }
        return last;
    }

    // Find Last Occurrence Function
    // Time - 2 * O(log2N), Space - O(1)
    static int[] findFirstAndLastOccurrence(int[] arr, int target) {
        // find first occurrence
        int first = findFirstOccurrence(arr, target);
        // first occurrence is not found (means first and last occurrence is not present in the array)
        if (first == -1) return new int[] {-1, -1};
        // find last occurrence
        int last = findLastOccurrence1(arr, target);
        // return first and last occurrence
        return new int[] {first, last};
    }

    // Count Occurrences Function
    // Time - 2 * O(log2N), Space - O(1)
    static int count(int[] arr, int target) {
        int[] ans = findFirstAndLastOccurrence(arr, target);
        // first occurrence is not found (means first and last occurrence is not present in the array)
        if (ans[0] == -1) return 0;
        // return the count of occurrences (last - first + 1)
        return ans[1] - ans[0] + 1;
    }

    //     Main Function
    public static void main(String[] args) {
        int[] arr =  {2, 4, 6, 8, 8, 8, 11, 13};
        int n = 8, x = 8;
        int ans = count(arr, x);
        System.out.println("The number of occurrences is: " + ans);
    }
}

// Output:
// First Occurrence is: 3, and Last Occurrence is: 5
// The number of occurrences is: 3

// Algorithm : Brute Force
/*
1. Initialize first = -1 and last = -1
2. Run a loop from i=0 to n-1
3. If target == arr[i], then first = i
4. Else last = i
5. Return first and last
 */

// Algorithm : Optimal Solution (Find First & Last Occurrence)
/*
1. Find the first occurrence of the target element using the findFirstOccurrence() function.
2. If the first occurrence is not found, then return {-1, -1}
3. Else, find the last occurrence of the target element using the findLastOccurrence() function.
4. Return {first, last}
 */

// Algorithm : Optimal Solution (Count Occurrences)
/*
1. Find the first occurrence of the target element using the findFirstOccurrence() function.
2. If the first occurrence is not found, then return 0
3. Else, find the last occurrence of the target element using the findLastOccurrence() function.
4. Return last - first + 1
 */

// Striver Video Explanation : https://www.youtube.com/watch?v=hjR1IYVx9lY