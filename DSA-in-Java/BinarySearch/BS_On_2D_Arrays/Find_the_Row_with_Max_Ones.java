package BinarySearch.BS_On_2D_Arrays;

import java.util.ArrayList;
import java.util.Arrays;

public class Find_the_Row_with_Max_Ones {

    // Method 1 : Brute Force
    // Time : O(n X m), where n = given row number, m = given column number.
    // Reason: We are using nested loops running for n and m times respectively.
    // Space : O(1) as we are not using any extra space.
    public static int rowWithMax(ArrayList<ArrayList<Integer>> matrix, int n, int m) {
        int cnt_max = 0;
        int index = -1;

        // traverse the matrix:
        for (int i = 0; i < n; i++) {
            int cnt_ones = 0;
            for (int j = 0; j < m; j++) {
                cnt_ones += matrix.get(i).get(j);
            }
            if (cnt_ones > cnt_max) {
                cnt_max = cnt_ones;
                index = i;
            }
        }
        return index;
    }

    // Implement Lower Bound
    public static int lowerBound(ArrayList<Integer> arr, int n, int x) {
        int low = 0, high = n - 1;
        int ans = n;

        while (low <= high) {
            int mid = (low + high) / 2;
            // maybe an answer
            if (arr.get(mid) >= x) {
                ans = mid;
                // look for smaller index on the left
                high = mid - 1;
            } else {
                low = mid + 1; // look on the right
            }
        }
        return ans;
    }

    // Method 2 : Optimal Solution
    public static int rowWithMax1s(ArrayList<ArrayList<Integer>> matrix, int n, int m) {
        int cnt_max = 0;
        int index = -1;

        // traverse the matrix:
        for (int i = 0; i < n; i++) {
            int cnt_ones = m - lowerBound(matrix.get(i), m, 1);
            if (cnt_ones > cnt_max) {
                cnt_max = cnt_ones;
                index = i;
            }
        }
        return index;
    }

    // Main Function
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> matrix = new ArrayList<>();
        matrix.add(new ArrayList<>(Arrays.asList(0, 1, 1)));
        matrix.add(new ArrayList<>(Arrays.asList(0, 0, 1)));
        matrix.add(new ArrayList<>(Arrays.asList(1, 1, 1)));

        int n = 3, m = 3;
        System.out.println("The row with the maximum number of 1's is: " +
                rowWithMax1s(matrix, n, m));
    }
}

// Output -
// The row with the maximum number of 1's is: 2

// Algorithm : Brute Force
/*
Algorithm / Intuition
In the question, it is clearly stated that we should return -1 if the matrix does not contain any 1.

The extremely naive approach is to traverse the matrix as usual using nested loops and for every single
row count the number of 1’s. Finally, we will return the row with the maximum no. of 1’s. If multiple
rows contain the maximum no. of 1’s we will return the row with the minimum index.

Algorithm:

The steps are as follows:

1. First, we will declare 2 variables i.e. cnt_max(initialized with 0), and index(initialized with -1).
The first variable will store the maximum number of 1’s we have got and the ‘index’ will store the row
number.
2. Next, we will start traversing the matrix. We will use a loop(say i) to select each row at a time.
3. Now, for each row i, we will use another loop(say j) and count the number of 1’s in that row.
4. After that, we will compare it with cnt_max and if the current number of 1’s is greater, we will update
cnt_max with the current no. of 1’s and ‘index’ with the current row index.
5. Finally, we will return the variable ‘index’. It will store the index of the row with the maximum no. of 1’s.
And otherwise, it will store -1.

Note: As we want the row with the minimum index, we will only update the index if the current number
of 1’s is greater than cnt_max (we will not update if they are equal).
 */

// Algorithm : Optimal Solution
/*
Algorithm / Intuition
We are going to use the Binary Search algorithm to optimize the approach.

The primary objective of the Binary Search algorithm is to efficiently determine the appropriate half to eliminate,
thereby reducing the search space by half. It does this by determining a specific condition that ensures that the
target is not present in that half.

We cannot optimize the row traversal but we can optimize the counting of 1’s for each row.

Instead of counting the number of 1’s, we can use the following formula to calculate the number of 1’s:
Number_of_ones = m(number of columns) – first occurrence of 1(0-based index).

As, each row is sorted, we can find the first occurrence of 1 in each row using any of the following approaches:

* lowerBound(1) (ref: Implement Lower Bound)
* upperBound(0) (ref: Implement Upper Bound)
* firstOccurrence(1) (ref: First and Last Occurrences in Array)

Note: Here, we are going to use the lowerBound() function to find the first occurrence. You can use the other
methods as well.

Algorithm:

1. First, we will declare 2 variables i.e. cnt_max(initialized with 0), and index(initialized with -1). The first
variable will store the maximum number of 1’s we have got and ‘index’ will store the row number.
2. Next, we will start traversing the rows. We will use a loop(say i) to select each row at a time.
3. Now, for each row i, we will use lowerBound() to get the first occurrence of 1. Now, using the following formula
we will calculate the number of 1’s:
Number_of_ones = m(number of columns) – lowerBound(1)(0-based index).
4. After that, we will compare it with cnt_max and if the current number of 1’s is greater, we will update cnt_max
with the current no. of 1’s and ‘index’ with the current row index.
5. Finally, we will return the variable ‘index’. It will store the index of the row with the maximum no. of 1’s. And
if the matrix does not contain any 1, it stores -1.
Note: As we want the row with the minimum index, we will only update the index if the current number of 1’s is greater
than cnt_max (we will not update if they are equal).
 */

// Striver (Video Explanation) : https://youtu.be/SCz-1TtYxDI