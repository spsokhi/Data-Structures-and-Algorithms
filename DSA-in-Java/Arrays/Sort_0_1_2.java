package Arrays;

import java.util.Arrays;

public class Sort_0_1_2 {

    // Method 1 - Brute Force
    // Time - O(NLogN), Space - O(N)
//    public static void sort(int[] arr) {
//        Arrays.sort(arr);
//    }

    // Method 2 - Better Solution
    // Time Complexity: O(N) + O(N), where N = size of the array. First O(N) for counting the number
    // of 0’s, 1’s, 2’s, and second O(N) for placing them correctly in the original array.
    // Space Complexity: O(1) as we are not using any extra space.
//    public static void sort(int[] arr, int n) {
//        int cnt0 = 0;
//        int cnt1 = 0;
//        int cnt2 = 0;
//
//        for(int i=0; i<n; i++) {
//            if(arr[i] == 0) cnt0++;
//            else if(arr[i] == 1) cnt1++;
//            else if (arr[i] == 2) cnt2++;
//        }
//
//        for(int i=0; i< cnt0; i++) {
//            arr[i] = 0;
//        }
//        for(int i=cnt0; i< (cnt0) + (cnt1); i++) {
//            arr[i] = 1;
//        }
//        for(int i=(cnt0) + (cnt1); i<n; i++) {
//            arr[i] = 2;
//        }
//    }

    // Method 3 - Optimal Solution
    // Time Complexity: O(N), Space Complexity: O(1)
    public static void sort(int[] arr) {
        int low = 0;
        int mid = 0;
        int high = arr.length-1;

        while(mid <= high) {
            if (arr[mid] == 0) {
                swap(arr, low, mid);
                low++;
                mid++;
            }
            else if (arr[mid] == 1) {
                mid++;
            }
            else {
                swap(arr, mid, high);
                high--;
            }
        }
    }

    // Swap Function
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // Main Function
    public static void main(String[] args) {
        int[] arr = {0, 2, 1, 2, 0, 1};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}

// Algorithm - Brute Force
/*
1. Sort the array in ascending order.
2. Print the (size of the array -1)th index.
 */

// Algorithm - Better Solution
/*
1. Count the number of 0’s, 1’s, 2’s.
2. Place them in the original array.
 */

// Algorithm - Optimal Solution
/*
1. Take three variables low, mid, high.
2. low = 0, mid = 0, high = n-1.
3. If arr[mid] == 0, swap(arr[low], arr[mid]), low++, mid++.
4. If arr[mid] == 1, mid++.
5. If arr[mid] == 2, swap(arr[mid], arr[high]), high--.
6. Repeat the above steps until mid <= high.

// Intuition
This algorithm contains 3 pointers i.e. low, mid, and high, and 3 main rules.  The rules are the following:

1. arr[0….low-1] contains 0. [Extreme left part]
2. arr[low….mid-1] contains 1.
3. arr[high+1….n-1] contains 2. [Extreme right part], n = size of the array
The middle part i.e. arr[mid….high] is the unsorted segment. So, hypothetically the array with different
markers will look like the following:
 */

// Striver - https://www.youtube.com/watch?v=tp8JIuCXBaU