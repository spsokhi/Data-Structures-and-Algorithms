package Arrays.PascalTriangle;

import java.util.ArrayList;
import java.util.List;

public class Variation3 {

    // Variation 3: Given the number of rows n. Print the first n rows of Pascal’s triangle.

    // Calculating nCr
    // Time - O(r)
    static int nCr(int n, int r) {
        long ans = 1;
        for (int i=0; i<r; i++) {
            ans = ans * (n - i);
            ans = ans / (i + 1);
        }
        return (int) ans;
    }

    // Method 1 : Brute Force
    // Time - O(N * N * R), Space - O(1)
    static List<List<Integer>> pascalTriangle(int n) {
        List<List<Integer>> ans = new ArrayList<>();

        // Store the entire Pascal's triangle:
        for (int row = 1; row <= n; row++) {
            List<Integer> tempLst = new ArrayList<>(); // temporary list
            for (int col = 1; col <= row; col++) {
                tempLst.add(nCr(row - 1, col - 1));
            }
            ans.add(tempLst);
        }
        return ans;
    }

    // Method 2 : Optimal Solution
    // Time - O(N*N), Space - O(1)
    public static List<Integer> generateRow(int row) {
        long ans = 1;
        List<Integer> ansRow = new ArrayList<>();
        ansRow.add(1); //inserting the 1st element

        //calculate the rest of the elements:
        for (int col = 1; col < row; col++) {
            ans = ans * (row - col);
            ans = ans / col;
            ansRow.add((int)ans);
        }
        return ansRow;
    }

    public static List<List<Integer>> pascalTriangleOptimal(int n) {
        List<List<Integer>> ans = new ArrayList<>();

        //store the entire pascal's triangle:
        for (int row = 1; row <= n; row++) {
            ans.add(generateRow(row));
        }
        return ans;
    }

    // Main Function
    public static void main(String[] args) {
        int n = 5;
        List<List<Integer>> ans = pascalTriangleOptimal(n);
        System.out.println(ans);
    }
}

// Output -
// [[1], [1, 1], [1, 2, 1], [1, 3, 3, 1], [1, 4, 6, 4, 1]]

// Algorithm : Brute Force
/*
1. First, we will run a loop(say row) from 1 to n.
2. Inside the loop, we will call a generateRow() function and add the returned list to our final answer. Inside the function we will do the following:
    1. First, we will store the 1st element i.e. 1 manually.
    2. After that, we will use a loop(say col) that runs from 1 to n-1. It will store the rest of the elements.
    3. Inside the loop, we will use the specified formula to print the element. We will multiply the previous answer by (row-col) and then divide it by col itself.
Thus, the entire row will be stored and returned.
Finally, we will return the answer list.
 */

// Algorithm : Optimal Solution
/*
1. First, we will run a loop(say row) from 1 to n.
2. Inside the loop, we will call a generateRow() function and add the returned list to our final answer. Inside the function we will do the following:
    1. First, we will store the 1st element i.e. 1 manually.
    2. After that, we will use a loop(say col) that runs from 1 to n-1. It will store the rest of the elements.
    3. Inside the loop, we will use the specified formula to print the element. We will multiply the previous answer by (row-col) and then divide it by col itself.
    4. Thus, the entire row will be stored and returned.
3. Finally, we will return the answer list.
 */

// Striver : (Video Explanation) https://youtu.be/bR7mQgwQ_o8