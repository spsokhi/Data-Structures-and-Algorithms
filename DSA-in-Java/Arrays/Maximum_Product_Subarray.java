package Arrays;

public class Maximum_Product_Subarray {

    // Method 1 : Brute Force
    // Time Complexity: O(n^3), where n is the size of the given array.
    // Reason: We are using 3 nested loops each running for n times. So, the time complexity will be O(n^3).
    // Space Complexity: O(1) as we are not using any extra space.
//    static int maxProduct(int[] arr) {
//        int n = arr.length;
//        int max = Integer.MIN_VALUE;
//
//        for (int i=0; i<n; i++) {
//            for (int j=i; j<n; j++) {
//                int prod = 1;
//                for (int k=i; k<=j; k++) {
//                    prod *= arr[k];
//                }
//
//                max = Math.max(max, prod);
//            }
//        }
//        return max;
//    }


    // Method 2 : Better Solution
    // Time Complexity: O(n^2), where n is the size of the given array.
    // Reason: We are using 2 nested loops each running for n times. So, the time complexity will be O(n^2).
    // Space Complexity: O(1) as we are not using any extra space.
//    static int maxProduct2(int[] arr) {
//        int n = arr.length;
//        int max = Integer.MIN_VALUE;
//
//        for (int i=0; i<n; i++) {
//            int prod = 1;
//            for (int j=i; j<n; j++) {
//                prod *= arr[j];
//                max = Math.max(max, prod);
//            }
//        }
//        return max;
//    }

    // Method 3 : Optimal Solution
    // Time Complexity: O(n), where n is the size of the given array.
    // Reason: We are using only one loop running for n times. So, the time complexity will be O(n).
    // Space Complexity: O(1) as we are not using any extra space.
    static int maxProduct3(int[] arr) {
        int n = arr.length;
        int max = Integer.MIN_VALUE;

        int pre = 1;
        int suf = 1;

        for (int i=0; i<n; i++) {
            pre *= arr[i];
            suf *= arr[n-i-1];

            if (pre == 0) pre = 1;
            if (suf == 0) suf = 1;

            max = Math.max(max, Math.max(pre, suf));
        }
        return max;
    }

    // Main Function
    public static void main(String[] args) {
        int[] arr = {2, 3, -1, 4};
        System.out.println(maxProduct3(arr));
    }
}

// Output -
// 6

// Algorithm : Brute Force (Generate all subarrays)
/*
1. Start a loop from i=0 to n.
2. Start another loop from j=i to n.
3. Start another loop from k=i to k<=j & product of between i to j.
4. Update the maximum product.
5. Return the maximum product.
 */

// Algorithm : Better Solution (Generate all subarrays)
/*
1. Start a loop from i=0 to n.
2. Initialize a variable prod = 1.
3. Start another loop from j=i to n.
4. Update prod = prod * arr[j].
5. Update the maximum product.
6. Return the maximum product.
 */

// Cases :
/*
1. If the array contains only positive elements.
2. Even Negative, Positive.
3. Odd negative, Positive.
4. Arrays containing zero.
 */
// Algorithm : Optimal Solution
/*
1. Iteration from left to right once to get maximum product for forward direction.
2. If zero is encountered, we set all variables again to initial value.
3. Iteration from right to left once again to get maximum product for backward direction.
4. If zero is encountered, we set all variables again to zero to find a new subarray with maximum product.
5. Once both iterations are completed, the overall result for the maximum product subarray of the given array is
the maximum product obtained from both the iterations.
 */

// Algorithm
/*
1. Initialize a variable pre = 1, suf = 1, max = Integer.MIN_VALUE.
2. Start a loop from i=0 to n.
3. Update pre = pre * arr[i], suf = suf * arr[n-i-1].
4. If pre == 0, then pre = 1.
5. If suf == 0, then suf = 1.
6. Update max = max(max, max(pre, suf)).
7. Return max.
 */