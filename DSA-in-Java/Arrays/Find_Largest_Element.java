package Arrays;

import java.util.Arrays;

public class Find_Largest_Element {

    // Find Largest Element Function
    public static int findLargest(int[] arr) {

        // Method 1 : Brute Force
//        Arrays.sort(arr);
//        return arr[arr.length-1];


        // Method 2 : Optimal Solution
        int max = arr[0];
        for(int i=1; i< arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }

    // Main Function
    public static void main(String[] args) {
        int[] arr = {7,8,3,9,1};
        int res = findLargest(arr);
        System.out.println(res);
    }
}

// Approach 1 : Using Sorting
/*
1. Sort the array in ascending order.
2. Print the (size of the array -1)th index.
3. For Sorting Method:

Time Complexity: O(N*log(N))
Space Complexity: O(N)
*/

// Approach 2 : Using a max Variable
/*
1. Create a max variable and initialize it with arr[0].
2. Use a for loop and compare it with other elements of the array
3. If any element is greater than the max value, update max value with the element’s value
4. Print the max variable.

Time Complexity: O(N)
Space Complexity: O(1)
 */

// Striver (Videos Explanation) - https://www.youtube.com/watch?v=37E9ckMDdTk
