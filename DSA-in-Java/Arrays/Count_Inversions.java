package Arrays;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Count_Inversions {

    // Method 1 : Brute Force
    // Time Complexity: O(N2), where N = size of the given array.
    // Reason: We are using nested loops here and those two loops roughly run for N times.
    // Space Complexity: O(1) as we are not using any extra space to solve this problem.
//    static int countInversion(int[] arr) {
//        int n = arr.length;
//        int count = 0;
//
//        for (int i=0; i<n; i++) {
//            for (int j=i+1; j<n; j++) {
//                if (arr[i] > arr[j]) {
//                    count++;
//                }
//            }
//        }
//        return count;
//    }

    // Method 2 : Optimal Solution (Using Merge Sort)
    // Time Complexity: O(N*logN), where N = size of the given array.
    // Reason: We are not changing the merge sort algorithm except by adding a variable to it.
    // So, the time complexity is as same as the merge sort.
    // Space Complexity: O(N), as in the merge sort We use a temporary array to store elements in sorted order.
    private static int merge(int[] arr, int low, int mid, int high) {
        ArrayList<Integer> temp = new ArrayList<>(); // temporary array
        int left = low;      // starting index of left half of arr
        int right = mid + 1;   // starting index of right half of arr

        //Modification 1: cnt variable to count the pairs:
        int cnt = 0;

        //storing elements in the temporary array in a sorted manner//

        while (left <= mid && right <= high) {
            if (arr[left] <= arr[right]) {
                temp.add(arr[left]);
                left++;
            } else {
                temp.add(arr[right]);
                cnt += (mid - left + 1); //Modification 2
                right++;
            }
        }

        // if elements on the left half are still left //

        while (left <= mid) {
            temp.add(arr[left]);
            left++;
        }

        // if elements on the right half are still left //
        while (right <= high) {
            temp.add(arr[right]);
            right++;
        }

        // transferring all elements from temporary to arr //
        for (int i = low; i <= high; i++) {
            arr[i] = temp.get(i - low);
        }
        return cnt; // Modification 3
    }

    public static int mergeSort(int[] arr, int low, int high) {
        int cnt = 0;
        if (low >= high) return cnt;
        int mid = (low + high) / 2 ;
        cnt += mergeSort(arr, low, mid);  // left half
        cnt += mergeSort(arr, mid + 1, high); // right half
        cnt += merge(arr, low, mid, high);  // merging sorted halves
        return cnt;
    }

    // Count Inversion Function
    public static int countInversions(int[] a, int n) {
        // Count the number of pairs:
        return mergeSort(a, 0, n - 1);
    }

    // Main Function
    public static void main(String[] args) {
        int[] arr = {6, 3, 9, 5, 2, 8};
        System.out.println(countInversions(arr, arr.length));
    }
}

/*
What is an inversion of an array? Definition: for all i & j < size of array, if i < j then you have to
find pair (A[i],A[j]) such that A[j] < A[i].

Example:
Input: [6, 3, 9, 5, 2, 8]
Output: 8
 */

// Output:
// 8

// Algorithm : Brute Force
/*
1. First, we will run a loop(say i) from 0 to N-1 to select the first element in the pair.
2. As index j should be greater than index i, inside loop i, we will run another loop i.e. j from i+1 to N-1.
3. Inside this second loop, we will check if a[i] > a[j] i.e. if a[i] and a[j] can be a pair. If they satisfy the
condition, we will increase the count by 1.
4. Finally, we will return the count i.e. the number of such pairs.
 */

// Algorithm : Optimal Solution (Using Merge Sort)
/*
Approach:
The steps are basically the same as they are in the case of the merge sort algorithm. The change will be just a
one-line addition inside the merge() function. Inside the merge(), we need to add the number of pairs to the count
when a[left] > a[right].

The steps of the merge() function were the following:

1. In the merge function, we will use a temp array to store the elements of the two sorted arrays after merging.
Here, the range of the left array is low to mid and the range for the right half is mid+1 to high.
2. Now we will take two pointers left and right, where left starts from low and right starts from mid+1.
3. Using a while loop( while(left <= mid && right <= high)), we will select two elements, one from each half, and
will consider the smallest one among the two. Then, we will insert the smallest element in the temp array.
4. After that, the left-out elements in both halves will be copied as it is into the temp array.
5. Now, we will just transfer the elements of the temp array to the range low to high in the original array

Modifications in merge() and mergeSort():

1. In order to count the number of pairs, we will keep a count variable, cnt, initialized to 0 beforehand inside the merge().
2. While comparing a[left] and a[right] in the 3rd step of merge(), if a[left] > a[right], we will simply add this line:
cnt += mid-left+1 (mid+1 = size of the left half)
3. Now, we will return this cnt from merge() to mergeSort().
4. Inside mergeSort(), we will keep another counter variable that will store the final answer. With this cnt, we will add the answer returned from mergeSort() of the left half, mergeSort() of the right half, and merge().
5. Finally, we will return this cnt, as our answer from mergeSort().
 */

// Striver's Video Explanation : https://www.youtube.com/watch?v=AseUmwVNaoY