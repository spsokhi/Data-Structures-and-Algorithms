package BinarySearch.BS_On_2D_Arrays;

public class Matrix_Median {

    // Method 1 : Brute Force
    // Time : O(row*col log(row*col)) for sorting the array where r*c denotes the number of elements
    // in the linear array.
    // Space : O(row*col) for storing elements in the linear array
//    public static int findMedian(int[][] arr, int row, int col) {
//        int[] median = new int[row * col];
//        int index = 0;
//        for (int i=0; i<row; i++) {
//            for (int j=0; j<col; j++) {
//                median[index] = arr[i][j];
//                index++;
//            }
//        }
//        return median[(row * col) / 2];
//    }

    // Method 2 : Optimal Solution
    // Time : O[(log2)10^9)] for binary search
    // O(n) * O(log2m) for count smaller value than mid function (count no. of elements smaller than tha mid)
    // Space : O(1) because we are not using extra space
    static int findMedian(int[][] matrix, int m, int n) {
        int low = Integer.MAX_VALUE, high = Integer.MIN_VALUE;

        // point low and high to right elements
        for (int i = 0; i < m; i++) {
            low = Math.min(low, matrix[i][0]);
            high = Math.max(high, matrix[i][n - 1]);
        }

        int req = (n * m) / 2;
        while (low <= high) {
            int mid = (low + high) / 2;
            int smallEqual = countSmallerThanMid(matrix, m, n, mid);
            if (smallEqual <= req) low = mid + 1;
            else high = mid - 1;
        }
        return low;
    }

    // Count Smaller than Mid Value Function
    // Time : O(n) * O(log2m) (where m is the length of the array)
    public static int countSmallerThanMid(int[][] arr, int n, int m, int x) {
        int count = 0;
        for (int i=0; i<n; i++) {
            count += upperBound(arr[i], x);
        }
        return count;
    }

    // Upper Bound Code
    // Time - O(log2N), Space - O(1)
    static int upperBound(int[] arr, int target) {
        int n = arr.length;

        int low = 0;
        int high = n-1;
        int ans = n;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] > target) {
                ans = mid;
                high = mid - 1;
            }
            else {
                low = mid+1;
            }
        }
        return ans;
    }

    // Main Function
    public static void main(String[] args) {
        int row = 3, col = 3;
        int[][] arr =
                {{1, 4, 9},
                        {2, 5, 6},
                        {3, 8, 7}};
        System.out.println("The median of the row-wise sorted matrix is: "+
                findMedian(arr, row, col));
    }
}

// Output :
// The median of the row-wise sorted matrix is: 3

// Algorithm : Brute Force
/*
1. It creates an integer array called median with a length of row * col to store all the elements of the 2D array.
2. It initializes an index variable to keep track of the current position in the median array.
3. It uses nested loops to iterate through each element of the 2D array (arr) and stores them in the median array,
   effectively flattening the 2D array into a 1D array.
4. Finally, it calculates and returns the element at the middle position in the median array as the median.
   The median of an array is typically the middle element if the array is sorted.

However, there are a few potential issues with this code:
Efficiency: This code creates a new array and copies all the elements from the 2D array into it. This can be
inefficient and consume extra memory if the input array is very large.

Median Calculation: The code assumes that the median is simply the middle element of the flattened array.
This is only true if the elements are sorted. If the elements are not sorted, this will not give the correct median value.

If you want to calculate the median of the elements in the 2D array correctly, you should sort the flattened array
and then find the middle element. You can use built-in sorting methods like Arrays.sort() to sort the array
before finding the median.
 */

// Algorithm : (Optimal Solution) 
/*
1. The findMedian function takes a 2D integer array arr, along with its dimensions n (number of rows)
and m (number of columns) as input.
2. It initializes two variables: low to 1 and high to 1,000,000,000 (1 billion). These values
represent the range in which the median will be searched.
3. It calculates required as the target position of the median, which is (n * m) / 2. This is because
 if you flatten the 2D array into a 1D array and sort it, the median will be at the position (n * m) / 2.
4. The code enters a binary search loop. Inside the loop, it calculates the middle value
mid as the average of low and high.
5. The countSmallerThanMid function is called to count the number of elements in the matrix smaller
than or equal to mid.
6. If the count of elements smaller than or equal to mid (smallestEquals) is less than or equal to the
required value, it means that the median must be greater than mid, so low is updated to mid + 1.
7. If smallestEquals is greater than required, it means that the median must be less than or equal to mid,
so high is updated to mid - 1.
8. This process continues until low is no longer less than or equal to high. At this point, low will be the median value.
Finally, the function returns the calculated low value as the median.

The countSmallerThanMid function counts the number of elements smaller than x in the 2D array by iterating through
each row and using the upperBound function to find the position in each row where the value is greater than x.

The upperBound function is a standard binary search algorithm used to find the index where the element in a sorted
array would be inserted to maintain the sorted order. It's used to count the number of elements smaller than x in a row.
 */

// Striver (Video Explanation) : https://youtu.be/63fPPOdIr2c
