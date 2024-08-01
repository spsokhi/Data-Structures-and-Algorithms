package Arrays;

public class Rotate_Image {

    // Method 1 : Brute Force (Using Temporary Array)
    // Time : O(N*N), to linearly iterate and put it into some other matrix.
    // Space : O(N*N), O(N*N) to copy it into some other matrix.
    static void rotateImage(int[][] matrix) {
        int n = matrix.length;

        int[][] ansMatrix = new int[n][n];

        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                ansMatrix[j][n-1-i] = matrix[i][j];
            }
        }

        // Print the Matrix
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                System.out.print(ansMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    // Method 2 : Optimal Solution (Using Transpose and Reverse)
    // Time : O(N*N) + O(N*N).One O(N*N) is for transposing the matrix and the other is for reversing the matrix.
    // Space : O(1) as we are not using any extra space.
    static void rotateImage1(int[][] matrix) {
        int n = matrix.length;

        // Transpose the matrix
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        // Reverse each row
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n / 2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][n - 1 - j];
                matrix[i][n - 1 - j] = temp;
            }
        }

        // Printing the matrix
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    // Main Function
    public static void main(String[] args) {
        int[][] matrix = {{1,2,3},
                {4,5,6},
                {7,8,9}};
        rotateImage(matrix);
    }
}

// Output :
// 7 4 1
// 8 5 2
// 9 6 3

// Algorithm : Brute Force (Using Temporary Array)
/*
1. Create a new matrix ansMatrix of same size as matrix.
2. Traverse the matrix and store the elements of matrix in ansMatrix in the following way:
    ansMatrix[j][n-1-i] = matrix[i][j]
3. Print the ansMatrix.
 */

// Algorithm : Optimal Solution (Using Transpose and Reverse)
/*
1. Transpose the matrix.
2. Reverse the matrix.
3. Print the matrix.
 */

// Striver (Video Link) : https://youtu.be/Z0R2u6gd3GU
// Striver (Video Link - 2): https://www.youtube.com/watch?v=Y72QeX0Efxw&t=1s
