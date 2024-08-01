package Arrays;

import java.util.ArrayList;

public class Leaders_in_Array {

    // Method 1 - Brute Force
    // Time - O(N^2), Space - O(N) for storing the answer
//    static ArrayList<Integer> leadersInArray (int[] arr, int n) {
//        ArrayList<Integer> ans = new ArrayList<>();
//
//        for (int i = 0; i < n; i++) {
//            boolean leader = true;
//
//            //Checking whether arr[i] is greater than all
//            //the elements in its right side
//            for (int j = i + 1; j < n; j++)
//                if (arr[j] > arr[i]) {
//                    // If any element found is greater than current leader
//                    // curr element is not the leader.
//                    leader = false;
//                    break;
//                }
//
//            // Push all the leaders in ans array.
//            if (leader) {
//                ans.add(arr[i]);
//            }
//        }
//        return ans;
//    }

    // Method 2 - Optimal Solution
    // Time - O(N), Space - O(N) for storing the answer
    static ArrayList<Integer> leadersInArray(int[] arr, int n) {
        ArrayList<Integer> ans = new ArrayList<>();

        int maxi = Integer.MIN_VALUE;
        for (int i=n-1; i>=0; i--) {
            if (arr[i] > maxi) {
                ans.add(arr[i]);
            }
            maxi = Math.max(maxi, arr[i]);
        }
        return ans;
    }

    // Main Function
    public static void main(String[] args) {
        int[] arr = {10, 22, 12, 3, 0, 6};
        int n = arr.length;
        ArrayList<Integer> ans = leadersInArray(arr, n);
        System.out.println(ans);
    }
}

// Output
// [6, 12, 22]

// Algorithm: Brute Force
/*
1. Using two loops, the outer loop runs from 0 to n-1 and the inner loop runs from i+1 to n-1.
2. For every element arr[i], check whether there is a greater element in the right side of the array.
3. If there is no greater element then print the element.
4. Else continue to the next element.
5. Return the answer array.
 */

// Algorithm: Optimal Solution
/*
1. Start traversing from right to left
2. If current element is greater than the maximum element so far, then print the current element.
3. Update the maximum element if possible.
4. Return the answer array.
 */

// Striver (Video Link) : https://youtu.be/cHrH9CQ8pmY