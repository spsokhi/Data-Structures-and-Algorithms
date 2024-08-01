package Arrays;

import java.util.ArrayList;

public class Reverse_Pairs {

    static int divide(int[] arr, int low, int high) {
        int count = 0;
        if (low >= high) return count;

        int mid = low + (high - low)/2;
        count += divide(arr, low, mid);
        count += divide(arr, mid+1, high);
        count += countPairs(arr, low, mid, high);
        merge(arr, low, mid, high);
        return count;
    }

    // Merge Function (same as Merge Sort)
    // Time Complexity: O(2N*logN), where N = size of the given array.
    // Reason: We are not changing the merge sort algorithm except by adding a variable to it.
    // So, the time complexity is as same as the merge sort.
    // Space Complexity: O(N), as in the merge sort We use a temporary array to store elements in sorted order.
    private static void merge(int[] arr, int low, int mid, int high) {
        ArrayList<Integer> temp = new ArrayList<>(); // temporary array
        int left = low;      // starting index of left half of arr
        int right = mid + 1;   // starting index of right half of arr

        //storing elements in the temporary array in a sorted manner//
        while (left <= mid && right <= high) {
            if (arr[left] <= arr[right]) {
                temp.add(arr[left]);
                left++;
            } else {
                temp.add(arr[right]);
                right++;
            }
        }

        // if elements on the left half are still left //

        while (left <= mid) {
            temp.add(arr[left]);
            left++;
        }

        //  if elements on the right half are still left //
        while (right <= high) {
            temp.add(arr[right]);
            right++;
        }

        // transfering all elements from temporary to arr //
        for (int i = low; i <= high; i++) {
            arr[i] = temp.get(i - low);
        }
    }

    // Count Pairs Function
    static int countPairs(int[] arr, int low, int mid, int high) {
        int right = mid+1;
        int count = 0;
        for (int i=low; i<=mid; i++) {
            while (right <= high && arr[i] > 2 * arr[right]) {
                right++;
                count += (right - (mid + 1));
            }
        }
        return count;
    }

    // Inversion Function (Question)
    static int inversions(int[] arr, int n) {
        return divide(arr, 0, n-1);
    }

    // Main Function
    public static void main(String[] args) {
        int[] arr = {4, 1, 2, 3, 1};
        int n = 5;
        int cnt = inversions(arr, n);
        System.out.println("The number of reverse pair is: " + cnt);
    }
}
