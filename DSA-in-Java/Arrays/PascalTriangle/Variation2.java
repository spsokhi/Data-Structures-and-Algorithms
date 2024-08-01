package Arrays.PascalTriangle;

public class Variation2 {

    // Variation 2:
    // Given the row number n. Print the n-th row of Pascal’s triangle.

    // Calculating nCr
    // Time - O(r)
    public static long nCr(int n, int r) {
        long res = 1;

        // calculating nCr:
        for (int i = 0; i < r; i++) {
            res = res * (n - i);
            res = res / (i + 1);
        }
        return res;
    }

    // Method 1 - Brute Force
    // Time - O(n * r), Space - O(1)
    public static void pascalTriangle(int n) {
        // printing the entire row n:
        for (int c = 1; c <= n; c++) {
            System.out.print(nCr(n - 1, c - 1) + " ");
        }
        System.out.println();
    }

    // Method 2 - Optimal Solution
    // Time - O(N), Space - O(1)
    public static void pascalTriangle1(int n) {
        long ans = 1;
        System.out.print(ans + " "); // printing 1st element

        // Printing the rest of the part:
        for (int i = 1; i < n; i++) {
            ans = ans * (n - i);
            ans = ans / i;
            System.out.print(ans + " ");
        }
        System.out.println();
    }


    // Main Function
    public static void main(String[] args) {
        int n = 5; // row number
        pascalTriangle(n);
        pascalTriangle1(n);
    }
}

// Output :
// 1 4 6 4 1

// Algorithm : Brute Force
/*
1. We will use a loop(say c) to iterate over each column i.e. from 1 to n. And for each column, we will do the following steps:
    1. First, we will consider n-1 as n and c-1 as r.
    2. After that, we will simply calculate the value of the combination using a loop.
    3. The loop will run from 0 to r. And in each iteration, we will multiply (n-i) with the result and divide the result by (i+1).
    4. Finally, we will print the element.
2. Finally, the entire row will be printed.
 */

// Algorithm : Optimal Solution
/*
1. First, we will print the 1st element i.e. 1 manually.
2. After that, we will use a loop(say i) that runs from 1 to n-1. It will print the rest of the elements.
3. Inside the loop, we will use the above-said formula to print the element. We will multiply the previous answer by (n-i) and then divide it by i itself.
4. Thus, the entire row will be printed.
 */

// Striver : (Video Explanation) https://youtu.be/bR7mQgwQ_o8

