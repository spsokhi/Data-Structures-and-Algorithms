package BinarySearch.BS_On_Answers;

public class Find_Nth_Root {

    // Power Exponential Method
    // Time Complexity : O(N)
    static int pow(int x, int n) {
        long power = 1;
        for (int i = 0; i < n; i++) {
            power *= x;
        }
        return (int) power;
    }

    // Find Nth Root Function
    // Time Complexity : O(N * log2M)
    // Space Complexity : O(1)
    static int findNthRoot(int m, int n) {
        int low = 1;
        int high = m;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int value = pow(mid, mid);
            if (value == m) return mid;

            if (value > m) high = mid - 1;
            else low = mid + 1;
        }
        return -1;
    }

    // Power Exponential Method
    // Time Complexity - O(log2N)
    static int powerExpo(int x, int n) {
        long power = 1;  // Result variable initialized to 1
        long base = x;   // Base initialized to x
        while (n > 0) {  // Loop until n becomes 0
            if ((n & 1) == 1) {  // If n is odd (n & 1 checks the least significant bit)
                power *= base;  // Multiply power by the current base
            }
            base *= base;  // Square the base
            n >>= 1;  // Divide n by 2 (right shift by 1 bit)
        }
        return (int) power;  // Return the result as an integer
    }

    // Main Function
    public static void main(String[] args) {
        int x = 27;
        int n = 3;
        int result = findNthRoot(x, n);
        if (result != -1) {
            System.out.println("The " + n + "th root of " + x + " is: " + result);
        } else {
            System.out.println(x + " does not have an integer " + n + "th root.");
        }
    }
}

// Intuition :
/*
We can guarantee that our answer will lie between the range from 1 to m i.e. the given number.
So, we will perform a linear search on this range and we will find the number x, such that
func(x, n) = m. If no such number exists, we will return -1.

Note: func(x, n) returns the value of x raised to the power n i.e. xn.
 */

// Striver Video Explanation : https://www.youtube.com/watch?v=rjEJeYCasHs