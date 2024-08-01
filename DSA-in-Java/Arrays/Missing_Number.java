package Arrays;

import jdk.jfr.consumer.RecordedThread;

import java.util.Arrays;

public class Missing_Number {


    // Method 1 - Brute Force (Using Linear Search)
    // Time - O(N * N), Space - O(1)
//    static int missingNumber(int[] arr, int n) {
//        // Outer loop that runs from 1 to N:
//        for (int i=1; i<=n; i++) {
//            // flag variable to check
//            // if an element exists
//            int flag = 0;
//            // i is present in the array:
//            for (int j=0; j<n-1; j++) {
//                if (arr[j] == i) {
//                    flag = 1;
//                    break;
//                }
//            }
//            // check if the element is missing
//            // i.e flag == 0:
//            if (flag == 0) return i;
//        }
//        // The following line will never execute.
//        // It is just to avoid warnings.
//        return -1;
//    }

    // Method 2 - Better Solution (Using Hashing)
    // Time - O(N) + O(N), Space - O(N)
//    static int missingNumber(int[] arr, int n) {
//        // Create a hashArray
//        int[] hash = new int[n+1];
//
//        // Initialize hashArray filled with 0
//        Arrays.fill(hash, 0);
//
//        // Traverse the array and mark the presence of each element in hashArray
//        for (int i=0; i<n-1; i++) {
//            hash[arr[i]] = 1;
//        }
//
//        // Traverse the hashArray and find the first element with value 0
//        for (int i=1; i<=n; i++) {
//            if (hash[i] == 0) {
//                return i;
//            }
//        }
//        return -1;
//    }

    // Method 3 - Optimal Solution (Using Sum of N Natural Numbers)
    // Time - O(N), Space - O(1)
//    static int missingNumber(int[] arr, int n) {
//        int sum = 0;
//        for (int i=0; i<n-1; i++) {
//            sum += arr[i];
//        }
//        return n*(n+1)/2 - sum;
//    }

    // Method 4 - Optimal Solution (Using XOR)
    // Time - O(N), Space - O(1)
    static int missingNumber(int[] arr, int n) {
        // find numbers between 1 to n using xor operation, like {1, 2, 3, 4, 5}
        int xor1 = 0;
        for (int i=1; i<=n; i++) {
            xor1 = xor1 ^ i;
        }

        // xor of array elements
        int xor2 = 0;
        for (int i=0; i<n-1; i++) {
            xor2 = xor2 ^ arr[i];
        }

        // return the missing number
        return xor1 ^ xor2;
    }

    // Main Function
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 5};
        int n = 5;
        int res = missingNumber(arr, n);
        System.out.println(res);
    }
}

// Output -
/*
The missing number is: 3
 */

// Algorithm: Brute Force (Using Linear Search)
/*
1. We will run a loop(say i) from 1 to N.
2. For each integer, i, we will try to find it in the given array using linear search.
    1. For that, we will run another loop to iterate over the array and consider a flag variable to indicate if the
    element exists in the array. Flag = 1 means the element is present and flag = 0 means the element is missing.
    2. Initially, the flag value will be set to 0. While iterating the array, if we find the element, we will set
    the flag to 1 and break out from the loop.
    Now, for any number i, if we cannot find it, the flag will remain 0 even after iterating the whole array and we
    will return the number.
 */

// Algorithm: Better Solution (Using HashArray)
/*
1. We will create a hashArray of size N+1 and initialize it with 0.
2. Now, we will iterate over the given array and mark the presence of each element in the hashArray.
3. After that, we will iterate over the hashArray and find the first element with value 0.
4. That element will be the missing number.
 */

// Algorithm: Optimal Solution (Using Sum of all Natural Numbers)
/*
1. We will find the sum of N natural numbers using the formula n*(n+1)/2.
2. Then, we will iterate over the array and find the sum of all the elements in the array.
3. The difference between the sum of N natural numbers and the sum of the array elements will be the missing number.
 */

// Algorithm: Optimal Solution (Using XOR)
/*
1. We will find the xor of all the numbers between 1 to N.
2. Then, we will find the xor of all the elements in the array.
3. The xor of both the above values will be the missing number.
 */

// Striver - (Video Link) https://youtu.be/bYWLJb3vCWY