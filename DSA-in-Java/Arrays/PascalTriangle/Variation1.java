package Arrays.PascalTriangle;

public class Variation1 {

    // Variation 1: Given row number r and column number c. Print the element at position (r, c) in Pascal’s triangle.
    // Time Complexity: O(c), where c = given column number.
    // Reason: We are running a loop for r times, where r is c-1.
    // Space Complexity: O(1) as we are not using any extra space.

    // Calculating nCr
    static int nCr(int n, int r) {
        long ans = 1;
        for (int i=0; i<r; i++) {
            ans = ans * (n - i);
            ans = ans / (i + 1);
        }
        return (int) ans;
    }

    // Find particular element function
    static int pascalTriangle(int row, int col) {
        int element = (int) nCr(row-1, col-1);
        return element;
    }

    // Main Function
    public static void main(String[] args) {
        // Variation 1:
        int r = 5; // row number
        int c = 3; // col number
        int element = pascalTriangle(r, c);
        System.out.println("The element at position (r,c) is: " + element);
    }
}

// Output :
// The element at position (r,c) is: 6

// nCr = n! / (r! * (n-r)!) Naive Approach
// nCr = r-1 C c-1 Optimal Approach

// Algorithm :
/*
1. First, we will consider r-1 as n and c-1 as r.
2. After that, we will simply calculate the value of the combination using a loop.
3. The loop will run from 0 to r. And in each iteration, we will multiply (n-i) with the result and divide the result by (i+1).
4. Finally, the calculated value of the combination will be our answer.
 */

// Striver : (Video Explanation) https://youtu.be/bR7mQgwQ_o8