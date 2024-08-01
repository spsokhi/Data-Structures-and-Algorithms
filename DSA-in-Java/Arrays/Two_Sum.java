package Arrays;

import java.util.Arrays;
import java.util.HashMap;

public class Two_Sum {

    // Brute Force
//    public static boolean twoSum(int[] arr, int target) {
//        for (int i=0; i< arr.length; i++) {
//            for (int j=0; j< arr.length; j++) {
//                if(arr[i] + arr[j] == target) {
//                    return true;
//                }
//            }
//        }
//        return false;
//    }

    // Method 2 - Using Two Pointer Approach
//    public static boolean twoSum(int[] arr, int target) {
//        Arrays.sort(arr);
//        int left = 0;
//        int right = arr.length - 1;
//        while (left < right) {
//            int sum = arr[left] + arr[right];
//            if (sum == target) {
//                return true;
//            }
//            else if (sum < target) left++;
//            else right--;
//        }
//        return false;
//    }

    // Method 3 - Using HashMap
    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i=0; i<nums.length; i++) {
            int first = nums[i];
            int mainTarget = target - first;
            if(map.containsKey(mainTarget)) {
                return new int[]{map.get(mainTarget), i};
            }
            else {
                map.put(nums[i], i);
            }
        }
        return new int[]{-1, -1};
    }

    // Main Function
    public static void main(String[] args) {
        int[] arr = {2, 7, 11, 15};
        int target = 17;
        int[] res = twoSum(arr, target);
        System.out.println(res);
    }
}

// Approaches

// Brute Force (Using Two Loops)
/*
1. First, we will use a loop(say i) to select the indices of the array one by one.
2. For every index i, we will traverse through the remaining array using another loop(say j) to find the other
number such that the sum is equal to the target (i.e. arr[i] + arr[j] = target).
 */

// Better Approach (Using Two Pointers)
/*
1. We will select the element of the array one by one using a loop(say i).
2. Then we will check if the other required element(i.e. target-arr[i]) exists in the hashMap.
    1. If that element exists, then we will return “YES” for the first variant or we will return the current index
    i.e. i, and the index of the element found using map i.e. mp[target-arr[i]].
    2. If that element does not exist, then we will just store the current element in the hashMap along with its index.
     Because in the future, the current element might be a part of our answer.
3. Finally, if we are out of the loop, that means there is no such pair whose sum is equal to the target. In this case,
we will return either “NO” or {-1, -1} as per the variant of the question.
 */

// Optimal Approach (Using Hashing)
/*
1. Create a HashMap
2. Iterate through the array
3. Find the first element
4. Find the mainTarget
5. Check if the mainTarget is present in the HashMap
6. If present, return the index of the mainTarget and the current element
7. Else, add the current element and its index to the HashMap
8. If no such pair is found, return [-1, -1]
 */

// Time & Space Complexity
/*
Time Complexity: O(N)
Space Complexity: O(N)
 */

// Striver - https://www.youtube.com/watch?v=UXDSeD9mN-k