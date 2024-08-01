package Arrays;

import java.util.Arrays;
import java.util.HashSet;

public class Longest_Consecutive_Sequence {

    // Method 1 : Brute Force
    // Time - O(N^3), Space - O(1)
//    static int longestSequence (int[] arr, int n) {
//
//        int longest = 0;
//
//        for (int i=0; i<n; i++) {
//            int curr = arr[i];
//            int count = 1;
//            while (contains(arr, curr+1)) {
//                curr++;
//                count++;
//            }
//            longest = Math.max(longest, count);
//        }
//        return longest;
//    }
//
//    // Contains Function (Helper Function)
//    static boolean contains (int[] arr, int target) {
//        for (int i=0; i<arr.length; i++) {
//            if (arr[i] == target) {
//                return true;
//            }
//        }
//        return false;
//    }

    // Method 2 : Better Solution (Using Sorting)
    // Time : O(N * log(N)). We are first sorting the array which will take O(N * log(N)) time and then we are running a for loop
    // which will take O(N) time. Hence, the overall time complexity will be O(N * log(N)).
    // Space : O(1). No extra space is required.
//    static int longestSequence2 (int[] arr, int n) {
//        int longest = 0;
//        int lastSmallest = Integer.MIN_VALUE;
//        int count = 0;
//
//        Arrays.sort(arr);
//        for (int i=0; i<n; i++){
//            if (arr[i]-1 == lastSmallest) {
//                count++;
//                lastSmallest = arr[i];
//            }
//            else if (arr[i] != lastSmallest) {
//                count = 1;
//                lastSmallest = arr[i];
//            }
//            longest = Math.max(longest, count);
//        }
//        return longest;
//    }

    // Method 3 : Optimal Solution (Using HashSet)
    // Time - O(N) The time complexity of the above approach is O(N) because we traverse each consecutive subsequence
    // only once. (assuming HashSet takes O(1) to search)
    // Space - O(N) The space complexity of the above approach is O(N) because we use a HashSet to store elements.
    static int longestSequence3(int[] arr, int n) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : arr) {
            set.add(num);
        }

        int longest = 0;
        for (int i=0; i<n; i++) {
            if (!set.contains(arr[i]-1)) {
                int curr = arr[i];
                int count = 1;

                while (set.contains(curr + 1)) {
                    curr++;
                    count++;
                }
                longest = Math.max(longest, count);
            }
        }
        return longest;
    }

    // Main Function
    public static void main(String[] args) {
        int[] arr = {100, 200, 1, 3, 2, 4};
        int n = arr.length;
        int ans = longestSequence3(arr, n);
        System.out.println(ans);
    }
}

// Output
// 4

// Algorithm: Brute Force
/*
1. We will traverse the array and for each element, we will check if the next element is present in the array or not.
2. If the next element is present in the array, we will increment the count and move to the next element.
3. If the next element is not present in the array, we will update the longest variable if the current count is
greater than the longest variable.
4. We will return the longest variable.
 */

// Algorithm: Better Solution (Using Sorting)
/*
1. We will sort the array.
2. We will traverse the array and for each element, we will check if the current element is equal to the previous
element or not.
3. If the current element is equal to the previous element, we will increment the count.
4. If the current element is not equal to the previous element, we will update the longest variable if the current
count is greater than the longest variable.
5. We will return the longest variable.
 */

// Algorithm: Optimal Solution (Using HashSet)
/*
1. We will create a HashSet and store all the elements of the array in the HashSet.
2. We will traverse the array and for each element, we will check if the previous element is present in the HashSet or not.
3. If the previous element is present in the HashSet, we will not do anything.
4. If the previous element is not present in the HashSet, we will check if the next element is present in the HashSet or not.
5. If the next element is present in the HashSet, we will increment the count and move to the next element.
6. If the next element is not present in the HashSet, we will update the longest variable if the current count is greater
than the longest variable.
7. We will return the longest variable.
 */

// Striver (Video Link): https://youtu.be/oO5uLE7EUlM