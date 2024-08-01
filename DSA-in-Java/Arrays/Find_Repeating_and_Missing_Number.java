package Arrays;

public class Find_Repeating_and_Missing_Number {

    // Method 1: Brute Force
    // Time Complexity: O(N^2), where N = the size of the given array.
    // Reason: We are using two loops each running for N times. So, the time complexity will be O(N^2).
    // Space Complexity: O(1) as we are not using any extra space.
    static int[] findMissingRepeatingNumbers(int[] arr) {
        int n = arr.length; // size of the array
        int repeating = -1, missing = -1;

        //Find the repeating and missing number:
        for (int i = 1; i <= n; i++) {
            //Count the occurrences:
            int cnt = 0;
            for (int j = 0; j < n; j++) {
                if (arr[j] == i) cnt++;
            }

            if (cnt == 2) repeating = i;
            else if (cnt == 0) missing = i;

            if (repeating != -1 && missing != -1)
                break;
        }
        int[] ans = {repeating, missing};
        return ans;
    }

    // Method 2 : Better Solution
    // Time Complexity: O(2N), where N = the size of the given array.
    // Reason: We are using two loops each running for N times. So, the time complexity will be O(2N).
    // Space Complexity: O(N) as we are using a hash array to solve this problem.
    static int[] findMissingRepeatingNumbers1(int[] arr) {
        int n = arr.length; // size of the array
        int[] hash = new int[n + 1]; // hash array

        //update the hash array:
        for (int i = 0; i < n; i++) {
            hash[arr[i]]++;
        }

        //Find the repeating and missing number:
        int repeating = -1, missing = -1;
        for (int i = 1; i <= n; i++) {
            if (hash[i] == 2) repeating = i;
            else if (hash[i] == 0) missing = i;

            if (repeating != -1 && missing != -1)
                break;
        }
        int[] ans = {repeating, missing};
        return ans;
    }

    // Method 3 : Optimal Solution 1
    // Time Complexity: O(N), where N = the size of the given array.
    // Reason: We are using only one loop running for N times. So, the time complexity will be O(N).
    // Space Complexity: O(1) as we are not using any extra space.
    static int[] findMissingRepeatingNumbers2(int[] arr) {
        long n = arr.length; // size of the array
        // Find Sn and S2n:
        long SN = (n * (n + 1)) / 2;
        long S2N = (n * (n + 1) * (2 * n + 1)) / 6;

        // Calculate S1 and S2:
        long S1 = 0, S2 = 0;
        for (int i = 0; i < n; i++) {
            S1 += arr[i];
            S2 += (long)arr[i] * (long)arr[i];
        }

        //S1-Sn = X-Y:
        long val1 = S1 - SN;

        // S2-S2n = X^2-Y^2:
        long val2 = S2 - S2N;

        //Find X+Y = (X^2-Y^2)/(X-Y):
        val2 = val2 / val1;

        //Find X and Y: X = ((X+Y)+(X-Y))/2 and Y = X-(X-Y),
        // Here, X-Y = val1 and X+Y = val2:
        long x = (val1 + val2) / 2;
        long y = x - val1;

        int[] ans = {(int)x, (int)y};
        return ans;
    }


    // Main Function
    public static void main(String[] args) {
        int[] a = {3, 1, 2, 5, 4, 6, 7, 5};
        int[] ans = findMissingRepeatingNumbers2(a);
        System.out.println("The repeating and missing numbers are: {"
                + ans[0] + ", " + ans[1] + "}");
    }
}

// Output: The repeating and missing numbers are: {5, 8}

// Algorithm : Brute Force
/*
1. We will run a loop(say i) from 1 to N.
2. For each integer, i, we will count its occurrence in the given array using linear search.
3. We will store those two elements that have the occurrence of 2 and 0.
4. Finally, we will return the elements.
 */

// Algorithm : Better Solution
/*
1. The range of the number is 1 to N. So, we need a hash array of size N+1 (as we want to store the frequency of N as well).
2. We will iterate all the elements of the given array and update the hash array accordingly i.e. hash[a[i]] = hash[a[i]]+1.
3. Now, we will iterate on the hash array and return the two elements with frequencies 2 and 0.
 */

// Algorithm : Optimal Solution 1
/*
Intuition:
The idea is to convert the given problem into mathematical equations. Since we have two variables i.e. missing and repeating, we will try to form two linear equations. And then we will find the values of two variables using those equations.

Assume the repeating number to be X and the missing number to be Y.

In the array, the numbers are between 1 to N, and in that range, one number is missing and one number is occurring twice.

// Step 1: Form equation 1:

Now, we know the summation of the first N numbers is:

Sn = (N*(N+1))/2
Let’s say, S = the summation of all the elements in the given array.

Therefore, S - Sn = X - Y…………………equation 1
// Step 2: Form equation 2:

Now, we know the summation of squares of the first N numbers is:

S2n = (N*(N+1)*(2N+1))/6
Let’s say, S2 = the summation of squares of all the elements in the given array.

Therefore, S2-S2n = X2-Y2...................equation 2
From equation 2 we can conclude,

X+Y = (S2 - S2n) / (X-Y) [From equation 1, we get the value X-Y] ………… equation 3
From equation 1 and equation 3, we can easily find the value of X and Y. And this is what we want.

Note: Here, we are summing all the numbers and squares of all the numbers, so we should use a bigger data type(Like in C++, long long instead of int).

Approach:
Assume the repeating number to be X and the missing number to be Y.

The steps are as follows:

1. First, find out the values of S and Sn and then calculate S – Sn (Using the above formulas).
2. Then, find out the values of S2 and S2n and then calculate S2 – S2n.
3. After performing steps 1 and 2, we will be having the values of X + Y and X – Y. Now, by substitution of values,
we can easily find the values of X and Y.
 */