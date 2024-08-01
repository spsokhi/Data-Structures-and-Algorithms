package BinarySearch.BS_On_Answers;

import java.util.ArrayList;

public class Kth_Element_of_Two_Sorted_Array {

    // Method 1 : Brute Force
    // Time Complexity: O(m+n), where m and n are the sizes of the given arrays.
    // Reason: We traverse through both arrays linearly.
    // Space Complexity: O(m+n), where m and n are the sizes of the given arrays.
    // Reason: We are using an extra array of size (m+n) to solve this problem.
    public static int kthElementBrute(ArrayList<Integer> a, ArrayList<Integer> b, int m, int n, int k) {
        ArrayList<Integer> arr3 = new ArrayList<>();

        // apply the merge step:
        int i = 0, j = 0;
        while (i < m && j < n) {
            if (a.get(i) < b.get(j)) arr3.add(a.get(i++));
            else arr3.add(b.get(j++));
        }

        // copy the left-out elements:
        while (i < m) arr3.add(a.get(i++));
        while (j < n) arr3.add(b.get(j++));

        return arr3.get(k - 1);
    }

    // Method 2 :  Better Solution
    // Time Complexity: O(m+n), where m and n are the sizes of the given arrays.
    // Reason: We traverse through both arrays linearly.
    // Space Complexity: O(1), as we are not using any extra space to solve this problem.
    public static int kthElementBetter(ArrayList<Integer> a, ArrayList<Integer> b, int m, int n, int k) {
        int ele = -1;
        int cnt = 0; //counter
        // apply the merge step:
        int i = 0, j = 0;
        while (i < m && j < n) {
            if (a.get(i) < b.get(j)) {
                if (cnt == k - 1) ele = a.get(i);
                cnt++;
                i++;
            } else {
                if (cnt == k - 1) ele = b.get(j);
                cnt++;
                j++;
            }
        }

        // copy the left-out elements:
        while (i < m) {
            if (cnt == k - 1) ele = a.get(i);
            cnt++;
            i++;
        }
        while (j < n) {
            if (cnt == k - 1) ele = b.get(j);
            cnt++;
            j++;
        }

        return ele;
    }

    // Method 3 : Optimal Solution
    // Time Complexity: O(log(min(m, n))), where m and n are the sizes of two given arrays.
    // Reason: We are applying binary search on the range [max(0, k-n2), min(k, n1)].
    // The range length <= min(m, n).
    // Space Complexity: O(1), as we are not using any extra space to solve this problem.
    public static int kthElementOptimal(ArrayList<Integer> a, ArrayList<Integer> b, int m, int n, int k) {
        if (m > n) return kthElementOptimal(b, a, n, m, k);

        int left = k; // length of left half

        // apply binary search:
        int low = Math.max(0, k - n), high = Math.min(k, m);
        while (low <= high) {
            int mid1 = (low + high) >> 1;
            int mid2 = left - mid1;
            // calculate l1, l2, r1, and r2
            int l1 = Integer.MIN_VALUE, l2 = Integer.MIN_VALUE;
            int r1 = Integer.MAX_VALUE, r2 = Integer.MAX_VALUE;
            if (mid1 < m) r1 = a.get(mid1);
            if (mid2 < n) r2 = b.get(mid2);
            if (mid1 - 1 >= 0) l1 = a.get(mid1 - 1);
            if (mid2 - 1 >= 0) l2 = b.get(mid2 - 1);

            if (l1 <= r2 && l2 <= r1) {
                return Math.max(l1, l2);
            }

            // eliminate the halves:
            else if (l1 > r2) high = mid1 - 1;
            else low = mid1 + 1;
        }
        return 0; // dummy statement
    }

    public static void main(String[] args) {
        ArrayList<Integer> a = new ArrayList<>();
        a.add(2); a.add(3); a.add(6); a.add(7); a.add(9);

        ArrayList<Integer> b = new ArrayList<>();
        b.add(1); b.add(4); b.add(8); b.add(10);

        System.out.println("The k-th element of two sorted arrays is: " +
                kthElementOptimal(a, b, a.size(), b.size(), 5));
    }
}

// Output :
// The element at the kth position in the final sorted array is 6

// Approach : Brute Force
/*
The extremely naive approach is to merge the two sorted arrays and then find the K-th element in that merged array.

How to merge two sorted arrays:
The word “merge” suggests applying the merge step of the merge sort algorithm . In that step, we essentially perform
the same actions as required by this solution. By using two pointers on two given arrays,
we fill up the elements into a third array.
 */

// Approach : Better Solution
/*
To optimize the space used in the previous approach, we can eliminate the third array used to store the final merged
result. After closer examination, we realize that we only need the k-th element at index (k-1),
rather than the entire merged array, to solve the problem effectively.

We will stick to the same basic approach, but instead of storing elements in a separate array, we will
use a counter called 'cnt' to represent the imaginary third array's index. As we traverse through the
arrays, when 'cnt' reaches the index (k-1), we will store that particular element. This way, we can
achieve the same goal without using any extra space.
 */

// Approach : Optimal Solution
/*
Approach :

Apply binary search in an array with a small size. Start iterating with two pointers, say left and right.
Find the middle of the range. Take elements from low to middle of array1 and the remaining elements from
the second array. Then using the condition mentioned above, check if the left half is valid. If valid,
print the maximum of both array’s last element. If not, move the range towards the right if l2 > r1,
else move the range towards the left if l1 > r2.
 */

// Video Explanation (Striver) : https://youtu.be/nv7F4PiLUzo