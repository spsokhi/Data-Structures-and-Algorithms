package BinarySearch.BS_On_2D_Arrays;

public class Find_Peak_Element_II {

    // Method 1 : Optimal Solution
    // Time : 0(log2m * n) where (m is high & n is low)
    // Reason : O(log2m) for binary search & O(n) for search max element in a column
    // Space : O(1) as we are not using any extra space.
    public int[] findPeakGrid(int[][] mat) {
        int low = 0;
        int high = mat[0].length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            int row = maxElement(mat, mat.length, mat[0].length, mid);
            int left = mid - 1 >= 0 ? mat[row][mid - 1] : -1;
            int right = mid + 1 < mat[0].length ? mat[row][mid + 1] : -1;
            if ((mat[row][mid] > left) && (mat[row][mid] > right)) {
                return new int[]{row, mid};
            } else if (left > mat[row][mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return new int[]{-1, -1};
    }

    // Find max element in column
    private static int maxElement(int[][] mat, int n, int m, int col) {
        int maxValue = -1;
        int index = -1;
        for(int i=0; i<n; i++) {
            if(mat[i][col] > maxValue) {
                maxValue = mat[i][col];
                index = i;
            }
        }
        return index;
    }
}

// Algorithm : Optimal Solution
/*
1. The maxElement method finds the row index with the maximum value in a specific column col of the matrix.
2. The findPeakGrid method performs a binary search on columns to find a peak element in the matrix.
    1. It initializes low and high for binary search.
    2. Inside the loop, it calculates the mid column index.
    3. It calls the maxElement method to find the row index with the maximum value in the mid column.
    4. It checks if the current element in the mid column is greater than its neighbors (left and right).
    If it is, it returns the coordinates of the peak element.
    5. If the current element is not a peak, it updates low or high for binary search based on whether the
    left neighbor is greater or the right neighbor is greater.
3. If the loop completes without finding a peak, it returns {-1, -1} to indicate that no peak element was
found in the matrix.
 */