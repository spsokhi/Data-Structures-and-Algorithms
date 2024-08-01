package Arrays;

import java.util.HashMap;

public class Majority_Element_Nby2_times {

    // Method 1 - Brute Force
    // Time Complexity: O(N^2), Space Complexity: O(1)
//    static int majorityElement(int[] arr, int n) {
//        for(int i=0; i<n; i++) {
//            int count = 0;
//            for (int j=0; j<n; j++) {
//                if (arr[j] == arr[i]) {
//                    count++;
//                }
//            }
//            if (count > n/2) {
//                return arr[i];
//            }
//        }
//        return -1;
//    }

    // Method 2 - Better Solution
    // Time Complexity: O(N*logN) + O(N), where N = size of the given array.
    // Space Complexity: O(N), because using HashMap
//    static int majorityElement(int[] arr, int n) {
//        HashMap<Integer, Integer> map = new HashMap<>();
//
//        for(int i=0; i<n; i++) {
//            if (map.containsKey(arr[i])) {
//                map.put(arr[i], map.get(arr[i]) + 1);
//            }
//            else {
//                map.put(arr[i], 1);
//            }
//        }
//
//        for (int key : map.keySet()) {
//            if (map.get(key) > n/2) {
//                return key;
//            }
//        }
//        return -1;
//    }

    // Method 3 - Optimal Solution (Using Moore's Voting Algorithm)
    // Time Complexity: O(N) + O(N), where N = size of the given array
    // Space Complexity: O(1)
    static int majorityElement(int[] nums) {
        int result = nums[0];
        int count = 1;

        for (int i=1; i< nums.length; i++) {
            if (nums[i] == result) {
                count++;
            }
            else {
                count--;
            }

            if (count == 0) {
                result = nums[i];
                count = 1;
            }

            int count2 = 0;
            for (int j=0; j<nums.length; j++) {
                if (nums[j] == result) {
                    count2++;
                }

                if (count2 > nums.length/2) {
                    return result;
                }
            }
        }
        return -1;
    }

    // Main Function
    public static void main(String[] args) {
        int[] arr = {1, 1, 2, 3, 1};
        int ans = majorityElement(arr);
        System.out.println("The majority element is: " + ans);
    }
}

// Algorithm - Brute Force
/*
1. Traverse the array and for each element, count its frequency.
2. If the frequency of any element is greater than n/2, then return that element.
3. Else, return -1.
 */

// Algorithm - Better Solution
/*
1. Create a HashMap.
2. Traverse the array and store the frequency of each element in the HashMap.
3. Traverse the HashMap and check if the frequency of any element is greater than n/2.
4. If yes, then return that element.
5. Else, return -1.
 */

// Algorithm - Optimal Solution
/*
1. Take two variables result and count.
2. Initialize result = arr[0], count = 1.
3. Traverse the array from i = 1 to n-1.
4. If arr[i] == result, then count++.
5. Else, count--.
6. If count == 0, then result = arr[i], count = 1.
7. Traverse the array from i = 0 to n-1.
8. If arr[i] == result, then count2++.
9. If count2 > n/2, then return result.
 */

// Striver - https://www.youtube.com/watch?v=nP_ns3uSh80