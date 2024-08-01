package Arrays;

import java.util.HashMap;

public class Longest_Subarray_with_Zero_Sum {

    // Method 1 - Brute Force (Using 3 loops)
    // Time Complexity: O(N^3), Space Complexity: O(1)
    static int longestSubarray(int[] arr) {
        int n = arr.length;

        int maxLen = 1;
        for (int i=0; i<n; i++) {
            for (int j=i; j<n; j++) {
                int sum = 0, count = 0;
                for (int k=i; k<=j; k++) {
                    sum += arr[k];
                    count++;

                    if (sum == 0) {
                        maxLen = Math.max(maxLen, count);
                    }
                }
            }
        }
        return maxLen;
    }

    // Method 2 - Better Solution (Using 2 loops)
    // Time Complexity: O(N^2), Space Complexity: O(1)
    static int longestSubarray1(int[] arr) {
        int n = arr.length;

        int maxLen = 1;
        for (int i=0; i<n; i++) {
            int sum = 0;
            int count = 0;
            for (int j=i; j<n; j++) {
                sum += arr[j];
                count++;

                if (sum == 0) {
                    maxLen = Math.max(maxLen, count);
                }
            }
        }
        return maxLen;
    }

    // Method 3 - Optimal Solution (Using HashMap)
    // Time Complexity: O(N), Space Complexity: O(N)
    static int longestSubarray2(int[] arr) {
        int n = arr.length;

        HashMap<Integer, Integer> map = new HashMap<>();
        int prefixSum = 0;
        int maxi = 0;

        for (int i=0; i<n; i++) {
            prefixSum += arr[i];
            if (prefixSum == 0) {
                maxi = i+1;
            }
            else {
                if (map.containsKey(prefixSum)) {
                    maxi = Math.max(maxi, i - map.get(prefixSum));
                }
                else {
                    map.put(prefixSum, i);
                }
            }
        }
        return maxi;
    }

    // Main Function
    public static void main(String[] args) {
        int[] arr = {6, -2, 2, -8, 1, 7, 4, -10};
//        int[] arr = {1, -1, 3, 2, -2, -8, 1, 7, 10, 23}; // for edge case
        int[] arr2 = {1, 0, -5};
        System.out.println(longestSubarray1(arr2));
    }
}

// Output
// 8

// Algorithm : Brute Force (Using 3 loops)
/*
1. Initialize a variable max = 1, which stores the length of the longest subarray with a sum of 0.
2. Run 3 loops, the outermost loop runs from i = 0 to i = n-1.
3. The second loop runs from j = i to j = n-1.
4. The third loop runs from k = i to k = j.
5. Calculate the sum of the subarray from k = i to k = j.
6. If the sum is 0, then update max = max(max, j-i+1).
7. Return max.
 */

// Algorithm : Better Solution (Using 2 loops)
/*
1. Initialize a variable max = 1, which stores the length of the longest subarray with a sum of 0.
2. Run 2 loops, the outermost loop runs from i = 0 to i = n-1.
3. Initialize a variable sum = 0, which stores the sum of the subarray from i = j to j = n-1.
4. Initialize a variable count = 0, which stores the length of the subarray from i = j to j = n-1.
5. Run the inner loop from j = i to j = n-1.
6. Update sum = sum + arr[j].
7. Update count = count + 1.
8. If sum = 0, then update max = max(max, count).
9. Return max.
 */

// Algorithm : Optimal Solution (Using HashMap)
/*
1. Initialize a variable max = 1, which stores the length of the longest subarray with a sum of 0.
2. Initialize a HashMap, which stores the prefix sum and its index.
3. Initialize a variable prefixSum = 0, which stores the prefix sum of the array.
4. Initialize a variable maxi = 0, which stores the index of the last occurrence of the prefix sum.
5. Run a loop from i = 0 to i = n-1.
6. Update prefixSum = prefixSum + arr[i].
7. If prefixSum = 0, then update maxi = i+1.
8. Else, if the prefixSum is present in the HashMap, then update maxi = max(maxi, i - map.get(prefixSum)).
9. Else, put the prefixSum and its index in the HashMap.
10. Return maxi.
 */

// Striver (Video Explanation) : https://youtu.be/xmguZ6GbatA