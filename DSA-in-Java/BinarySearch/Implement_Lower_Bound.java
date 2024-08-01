package BinarySearch;

public class Implement_Lower_Bound {

    // Method 1 : Brute Force
    // Time - O(N), Space - O(1)
    static int lowerBound(int[] arr, int target) {
        int n = arr.length;

        for (int i=0; i<n; i++) {
            if (arr[i] >= target) {
                return i;
            }
        }
        return n;
    }

    // Method 2 : Optimal Solution
    // Time - O(log2N), Space - O(1)
    static int lowerBound1(int[] arr, int target) {
        int n = arr.length;

        int low = 0;
        int high = n-1;
        int ans = n;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] >= target) {
                ans = mid;
                high = mid-1;
            }
            // do not alter tha answer because this
            // doesn't have a probability to be my answer
            // Case: {1, 2, 3, 3, 5, 8, 8, 10, 10, 11), target = 9
            else low = mid + 1;
        }
        return ans;
    }

    // Main Function
    public static void main(String[] args) {
        int[] arr = {3, 5, 8, 15, 19};
        int x = 9;
        int ind = lowerBound1(arr, x);
        System.out.println("The lower bound is the index: " + ind);
    }
}

// Lower Bound - Means
/*
The lower bound algorithm finds the first or the smallest index in a sorted array where the value at that index
is greater than or equal to a given key i.e. x.

The lower bound is the smallest index, ind, where arr[ind] >= x. But if any such index is not found, the lower
bound algorithm returns 'n' i.e. size of the given array.

// Idea

The lower bound algorithm returns the first occurrence of the target number if the number is present and otherwise,
it returns the nearest greater element of the target number.
 */

// Algorithm : Brute Force -
/*
During this traversal, each element will be compared with the target value, x. The index, i, where the
 condition arr[i] >= x is first satisfied, will be the answer.
 */

// Algorithm : Optimal Solution -
/*
We will declare the 2 pointers and an ‘ans’ variable initialized to n i.e. the size of the array(as If we don’t find any index, we will return n).

1. Place the 2 pointers i.e. low and high: Initially, we will place the pointers like this: low will point to the first index, and high will point to the last index.
2. Calculate the ‘mid’: Now, we will calculate the value of mid using the following formula:
    1. mid = (low+high) // 2 ( ‘//’ refers to integer division)
3. Compare arr[mid] with x: With comparing arr[mid] to x, we can observe 2 different cases:
    2. Case 1 – If arr[mid] >= x: This condition means that the index mid may be an answer. So, we will update the ‘ans’ variable with mid and search in the left half if there is any smaller index that satisfies the same condition. Here, we are eliminating the right half.
    3. Case 2 – If arr[mid] < x: In this case, mid cannot be our answer and we need to find some bigger element. So, we will eliminate the left half and search in the right half for the answer.
 */

// Striver Video Explanation : https://www.youtube.com/watch?v=6zhGS79oQ4k