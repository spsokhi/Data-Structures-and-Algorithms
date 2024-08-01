package Arrays;

import java.util.ArrayList;
import java.util.List;

public class Spiral_Matrix {

    // Method 1 : Optimal Solution
    // Time - O(N*M), { Since all the elements are being traversed once and there are total n x m elements
    // (m elements in each row and total n rows) so the time complexity will be O(n x m)}.
    // Space - O(N*M), for storing the answers
    public List<Integer> spiralOrder(int[][] matrix) {
        // Define ans list to store the result.
        List<Integer> ans = new ArrayList<>();

        int n = matrix.length; // no. of rows
        int m = matrix[0].length; // no. of columns

        // Initialize the pointers required for traversal.
        int top = 0, left = 0;
        int bottom = n-1, right = m-1;

        // Loop until all elements are not traversed.
        while (top <= bottom && left <= right) {

            // For moving left to right
            for (int i = left; i <= right; i++) {
                ans.add(matrix[top][i]);
            }
            top++;

            // For moving top to bottom
            for (int i = top; i <= bottom; i++) {
                ans.add(matrix[i][right]);
            }
            right--;

            // Edge Case 1: When there is a single row in the matrix,
            // These conditions are added to check if the matrix is a single column or a single row. So, whenever the elements
            // in a single row are traversed they cannot be traversed again backward so the condition is checked in the
            // right-to-left loop.
            // For moving right to left
            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    ans.add(matrix[bottom][i]);
                }
                bottom--;
            }

            // Edge Case 2: When there is a single column in the matrix,
            // When a single column is present, the condition is checked in the bottom-to-top loop as
            // elements from bottom to top cannot be traversed again.
            // For moving bottom to top
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    ans.add(matrix[i][left]);
                }
                left++;
            }
        }
        // Finally, return the answer list
        return ans;
    }

    // Main Function
    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}};
        Spiral_Matrix obj = new Spiral_Matrix();
        List<Integer> ans = obj.spiralOrder(matrix);
        System.out.println(ans);
    }
}

// Approach :
/*
In this approach, we will be using four loops to print all four sides of the matrix.

1st loop: This will print the elements from left to right.

2nd loop: This will print the elements from top to bottom.

3rd loop: This will print the elements from right to left.

4th loop: This will print the elements from bottom to top.
 */

// Steps :
/*
Steps:

Create and initialize variables top as starting row index, bottom as ending row index left as starting column index,
and right as ending column index. As shown in the image given below.
In each outer loop traversal print the elements of a square in a clockwise manner.

1. Print the top row,
> i.e. Print the elements of the top row from column index left to right and increase the count of the top so that it will move to the next row.
2. Print the right column,
> i.e. Print the rightmost column from row index top to bottom and decrease the count of right.
3. Print the bottom row, i.e.
> if top <= bottom, then print the elements of a bottom row from column right to left and decrease the count of bottom
4. Print the left column, i.e.
> if left <= right, then print the elements of the left column from the bottom row to the top row and increase the count of left.
Run a loop until all the squares of loops are printed.
 */

// Edge Cases :
/*
Note: As we can see in the code snippet below, two edge conditions are being added in the last two ‘for’ loops:
when we are moving from right to left and from bottom to top.

Edge Case 1: When there is a single row in the matrix,
These conditions are added to check if the matrix is a single column or a single row. So, whenever the elements
in a single row are traversed they cannot be traversed again backward so the condition is checked in the
right-to-left loop.

Edge Case 2: When there is a single column in the matrix,
When a single column is present, the condition is checked in the bottom-to-top loop as
elements from bottom to top cannot be traversed again.
 */

// Striver (Video Link) : https://youtu.be/3Zv-s9UUrFM