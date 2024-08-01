package Arrays;

import java.util.HashMap;

public class Count_Subarray_with_XOR_K {

    // Method 1 - Brute Force (Using 3 loops)
    // Time Complexity: O(N^3), Space Complexity: O(1)
//    static int subarrayWithXorK(int[] arr, int K) {
//        int n = arr.length;
//        int count = 0;
//
//        for (int i=0; i<n; i++) {
//            for (int j=i; j<n; j++) {
//                int xor = 0;
//                for (int k=i; k<=j; k++) {
//                    xor = xor ^ arr[k];
//                }
//                if (xor == K) {
//                    count++;
//                }
//            }
//        }
//        return count;
//    }

    // Method 2 - Better Solution (Using 2 loops)
    // Time Complexity: O(N^2), Space Complexity: O(1)
//    static int subarrayWithXorK(int[] arr, int K) {
//        int n = arr.length;
//        int count = 0;
//
//        for (int i=0; i<n; i++) {
//            int xor = 0;
//            for (int j=i; j<n; j++) {
//                xor = xor ^ arr[j];
//
//                if (xor == K) {
//                    count++;
//                }
//            }
//        }
//        return count;
//    }

    // Method 3 - Optimal Solution (Using HashMap)
    // Time Complexity: O(N), Space Complexity: O(N)
    public static int subarrayWithXorK(int []arr, int k) {
        int n = arr.length; //size of the given array.
        int xr = 0;
        HashMap<Integer, Integer> map = new HashMap<>(); //declaring the map.
        map.put(xr, 1); //setting the value of 0.
        int cnt = 0;

        for (int i = 0; i < n; i++) {
            // prefix XOR till index i:
            xr = xr ^ arr[i];

            //By formula: x = xr^k:
            int x = xr ^ k;

            // add the occurrence of xr^k
            // to the count:
            if (map.containsKey(x)) {
                cnt += map.get(x);
            }

            // Insert the prefix xor till index i
            // into the map:
            if (map.containsKey(xr)) {
                map.put(xr, map.get(xr) + 1);
            } else {
                map.put(xr, 1);
            }
        }
        return cnt;
    }

    // Main Method
    public static void main(String[] args) {
        int[] arr = {4, 2, 2, 6, 4};
        int k = 6;
        System.out.println(subarrayWithXorK(arr, k));
    }
}

// Output
// 4

// Algorithm : Brute Force (Using 3 loops)
/*
1. Initialize count to 0 which will store the number of subarrays with XOR as K.
2. Run 3 loops, the outer loop will start from 0 to n-1, the middle loop will start from i to n-1 and the
inner loop will start from j to k.
3. Calculate the XOR of all the elements from i to j and check if it is equal to K or not.
4. If it is equal to K, then increment count.
5. Return count.
 */

// Algorithm : Better Solution (Using 2 loops)
/*
1. Initialize count to 0 which will store the number of subarrays with XOR as K.
2. Run 2 loops, the outer loop will start from 0 to n-1 and the inner loop will start from i to n-1.
3. Initialize xor to 0.
4. Calculate the XOR of all the elements from i to j and check if it is equal to K or not.
5. If it is equal to K, then increment count.
6. Return count.
 */

// Algorithm : Optimal Solution (Using HashMap)
/*
1. First, we will declare a map to store the prefix XORs and their counts.
2. Then, we will set the value of 0 as 1 on the map.
3. Then we will run a loop(say i) from index 0 to n-1(n = size of the array).
4. For each index i, we will do the following:
    1. We will XOR the current element i.e. arr[i] to the existing prefix XOR.
    2. Then we will calculate the prefix XOR i.e. xr^k, for which we need the occurrence.
    3. We will add the occurrence of the prefix XOR xr^k i.e. mpp[xr^k] to our answer.
    4. Then we will store the current prefix XOR, xr in the map increasing its occurrence by 1.
 */

// Striver (Video Explanation) : https://youtu.be/eZr-6p0B7ME