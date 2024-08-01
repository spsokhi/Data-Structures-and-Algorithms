package Arrays;

import java.util.HashSet;

public class Remove_Duplicates_from_Sorted_Array {

    // Method 1 - Brute Force (Using HashSet)
    // Time - ((N*NlogN) + N), Space - O(N)
//    static int removeDuplicates(int[] nums) {
//        HashSet<Integer> set = new HashSet<>();
//        for (int i=0; i< nums.length; i++) {
//            set.add(nums[i]);
//        }
//
//        int k = set.size();
//        int j = 0;
//        for (int x : set) {
//            nums[j] = x;
//            j++;
//        }
//        return k;
//    }

    // Method 2 - Optimal Solution (Two Pointer Approach)
    // Time - O(N), Space - O(1)
    static int removeDuplicates(int[] nums) {
        int i = 0;
        for (int j=1; j<nums.length; j++) {
            if (nums[i] != nums[j]) {
                // update the element
                nums[i+1] = nums[j];
                // increment the index
                i++;
            }
        }
        return i+1;
    }

    // Main Function
    public static void main(String[] args) {
        int arr[] = {1,1,2,2,2,3,3};
        int k = removeDuplicates(arr);
        System.out.println("The array after removing duplicate elements is ");
        for (int i = 0; i < k; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}

// Algorithm: Brute Force
/*
1. Declare a HashSet.
2. Run a for loop from starting to the end.
3. Put every element of the array in the set.
4. Store size of the set in a variable K.
5. Now put all elements of the set in the array from the starting of the array.
6. Return K.
 */

// Algorithm: Optimal Solution
/*
1. Declare a variable i = 0.
2. Run a for loop from 1 to the end of the array.
3. If the element at index i is not equal to the element at index j,
   then increment i by 1 and put the element at index j at index i+1.
4. Return i+1.
 */

// Striver (Video Explanation) : https://youtu.be/37E9ckMDdTk