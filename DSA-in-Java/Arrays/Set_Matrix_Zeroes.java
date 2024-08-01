package Arrays;

public class Set_Matrix_Zeroes {

    // Method 1 : Brute Force
    // Time : O(N * M * (N + M)), Space : O(1)
//    static void setMatrixZeroes (int[][] matrix, int n, int m) {
//        // We will be using two boolean arrays to store the rows and columns which are to be made zero
//        boolean[] row = new boolean[n];
//        boolean[] col = new boolean[m];
//
//        for (int i=0; i<n; i++) {
//            for (int j=0; j<n; j++) {
//                if (matrix[i][j] == 0) {
//                    row[i] = true;
//                    col[j] = true;
//                }
//            }
//        }
//
//        // Making rows zero
//        for (int i=0; i<n; i++) {
//            if (row[i]) {
//                for (int j=0; j<n; j++) {
//                    matrix[i][j] = 0;
//                }
//            }
//        }
//
//        for (int j=0; j<n; j++) {
//            if (col[j]) {
//                for (int i=0; i<n; i++) {
//                    matrix[i][j] = 0;
//                }
//            }
//        }
//    }

    // Method 2 : Better Solution
    // Time : O(2 * n * m), Space : O(n) + O(m)
    static void setMatrixZeroes(int[][] matrix, int n, int m) {
        int[] row = new int[n];
        int[] col = new int[m];

        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                if (matrix[i][j] == 0) {
                    row[i] = 1;
                    col[j] = 1;
                }
            }
        }

        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                if (row[i] == 1 || col[j] == 1) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

    // Method 3 : Optimal Solution
    // Time : O(2 * n * m), Space : O(1)
    static void setMatrixZeroes1(int[][] matrix, int n, int m) {
//        int[] row = new int[n]; // -> matrix[..][0]
//        int[] col = new int[m]; // -> matrix[0][..]

        int col0 = 1;
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                if (matrix[i][j] == 0) {
                    // mark the ith row
                    matrix[i][0] = 0;
                    // mark the jth col
                    if (j != 0) {
                        matrix[0][j] = 0;
                    }
                    else {
                        col0 = 0;
                    }
                }
            }
        }

        for (int i=1; i<n; i++) {
            for (int j=1; j<m; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        if (matrix[0][0] == 0) {
            for (int j=0; j<m; j++) {
                matrix[0][j] = 0;
            }
        }

        if (col0 == 0) {
            for (int i=0; i<n; i++) {
                matrix[i][0] = 0;
            }
        }
    }

    // Main Function
    public static void main(String[] args) {
        int[][] matrix = {{1, 1, 1, 1},
                {1, 0, 1, 1},
                {1, 1, 0, 1},
                {0, 1, 1, 1}};
        int n = matrix.length;
        int m = matrix[0].length;
        setMatrixZeroes1(matrix, n, m);

        // Printing the matrix
        for (int[] row : matrix) {
            for (int col : row) {
                System.out.print(col + " ");
            }
            System.out.println();

        }
    }
}

// Output
// 1 0 3 0
// 0 0 0 0
// 9 0 11 0
// 0 0 0 0

// Algorithm : Brute Force
/*
1. Create two boolean arrays row[] and col[] of size n and m respectively.
2. Iterate over the matrix and mark the rows and columns which are to be made zero.
3. Iterate over the matrix again and make the rows and columns zero.
 */

// Algorithm : Better Solution
/*
1. Create two arrays row[] and col[] of size n and m respectively.
2. Iterate over the matrix and mark the rows and columns which are to be made zero.
3. Iterate over the matrix again and make the rows and columns zero.
 */

// Striver's Video Explanation : https://www.youtube.com/watch?v=N0MgLvceX7M