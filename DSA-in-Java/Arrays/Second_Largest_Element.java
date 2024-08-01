package Arrays;

import java.util.Arrays;

public class Second_Largest_Element {

    // Method 1 - Brute Force - Time - O(NLogN), Space - O(1)
//    public static int secondLargest(int[] arr) {
//        Arrays.sort(arr);
//        int n = arr.length;
//        int largest = arr[n-1];
//        int sLargest = 0;
//
//        for(int i=n-2; i>=0; i--) {
//            if(arr[i] != largest) {
//                sLargest = arr[i];
//                break;
//            }
//        }
//        return sLargest;
//    }

    // Method 2 - Better Solution -> Time - O(N), Space - O(1)
    // Find Largest Element in an Array
//    public static int largest(int[] arr) {
//        int n = arr.length;
//
//        int largest = Integer.MIN_VALUE;
//        for(int i=0; i<n; i++) {
//            if(arr[i] > largest) {
//                largest = arr[i];
//            }
//        }
//        return largest;
//    }
//
//    // Find Second Largest Element in an Array
//    public static int secondLargest(int[] arr) {
//        int n = arr.length;
//
//        int sLargest = -1;
//        for(int i=0; i<n; i++) {
//            if(arr[i] > sLargest && arr[i] != largest(arr)) {
//                sLargest = arr[i];
//            }
//        }
//        return sLargest;
//    }

    // Method 3 - Optimal Solution - Time - O(N), Space - O(1)
    public static int secondLargest(int[] arr) {
        int n = arr.length;

        int largest = -1;
        int sLargest = -1;

        for (int i=0; i<n; i++) {
            if(arr[i] > largest) {
                sLargest = largest;
                largest = arr[i];
            }

            // condition : for checking duplicates
            else if (arr[i] > sLargest && arr[i] != largest) {
                sLargest = arr[i];
            }
        }
        return sLargest;
    }

    // Main Function
    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 7, 7, 5};
        int res = secondLargest(arr);
        System.out.println(res);
    }
}

// Algorithm - Brute Force
/*
1. Sort the array in ascending order.
2. Print the (size of the array -2)th index.
3. For Sorting Method:
 */

// Algorithm - Better Solution
/*
1. Create a max variable and initialize it with arr[0].
2. Use a for loop and compare it with other elements of the array
3. If any element is greater than the max value, update max value with the element’s value
4. Print the max variable.
 */

// Algorithm - Optimal Solution
/*
1. Create a max variable and initialize it with arr[0].
2. Create a sMax variable and initialize it with Integer.MIN_VALUE.
3. Use a for loop and compare it with other elements of the array
4. If any element is greater than the max value, update sMax value with max value and max value with the
 element’s value
5. If any element is greater than the sMax value and not equal to max value, update sMax value with the
element’s value
6. Print the sMax variable.
 */

// Striver (Video Explanation) - https://www.youtube.com/watch?v=37E9ckMDdTk

