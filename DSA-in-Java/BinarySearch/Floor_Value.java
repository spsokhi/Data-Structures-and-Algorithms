package BinarySearch;

public class Floor_Value {

    // Method 1 : Optimal Solution
    // Time - O(log2N), Space - O(1)
    static int floor(int[] arr, int target) {
        int n = arr.length;

        int low = 0;
        int high = n-1;
        int ans = -1;

        while (low <= high) {
            // Find mid element
            int mid = low + (high - low) / 2;
            // If value is less than or equal to the target
            // we will store the value in ans variable and move to the right side
            if (arr[mid] <= target) {
                ans = arr[mid];
                low = mid+1;
            }
            // Else, we move to the left side
            // do not alter tha answer because this
            // doesn't have a probability to be my answer
            // Case: {1, 2, 3, 3, 5, 8, 8, 10, 10, 11), target = 9
            else {
                high = mid-1;
            }
        }
        return ans;
    }

    // Main Function
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 3, 5, 8, 8, 10, 10, 11};
        int target = 9;
        int res = floor(arr, target);
        System.out.println(res);
    }
}

// Output -
// 20

// Floor Value Means -
// Largest element in an array which is smaller than or equal to the target element.
// such that : arr[idx] <= target

// Algorithm : Optimal Solution
/*
1. Initialize low = 0, high = n-1, ans = -1
2. Run a loop until low <= high
3. Find mid = low + (high - low) / 2
4. If arr[mid] >= target, then ans = arr[mid] and high = mid-1
5. Else low = mid+1
6. Return ans
 */

// Striver Video Explanation : https://www.youtube.com/watch?v=6zhGS79oQ4k