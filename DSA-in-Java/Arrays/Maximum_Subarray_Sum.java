package Arrays;

public class Maximum_Subarray_Sum {

    // Method 1 - Brute Force
    // Time - O(N^3), Space - O(1)
//    static int subarraySum(int[] arr) {
//        int n = arr.length;
//        int maxSum = Integer.MIN_VALUE;   // maximum sum of subarray
//        for(int i=0; i<n; i++) {
//            for (int j=i; j<n; j++) {
//                // subarray = arr[i.....j]
//                int sum = 0;
//                // add all the elements of subarray:
//                for (int k=i; k<=j; k++) {
//                    sum += arr[k];
//                }
//                maxSum = Math.max(maxSum, sum);   // getting the maximum
//            }
//        }
//        return maxSum;
//    }

    // Method 2 - Better Solution
    // Time - O(N^2), Space - O(1)
//    static int subarraySum(int[] arr) {
//        int n = arr.length;
//        int maxSum = Integer.MIN_VALUE; // maximum sum of subarray
//
//        for (int i=0; i<n; i++) {
//            int sum = 0;
//            for (int j=i; j<n; j++) {
//                // current subarray = arr[i.....j]
//
//                // add the current element arr[j]
//                // to the sum i.e. sum of arr[i...j-1]
//                sum += arr[j];
//                maxSum = Math.max(maxSum, sum); // getting the maximum
//            }
//        }
//        return maxSum;
//    }

    // Method 3 - Optimal Solution
    // Time - O(N), Space - O(1)
    static int subarraySum(int[] nums) {
        int currSum = 0;
        int maxSum = Integer.MIN_VALUE;

        for(int i =0; i<nums.length; i++) {
            currSum += nums[i];

            if(currSum > maxSum) {
                maxSum = currSum;
            }

            if(currSum < 0) {
                currSum = 0;
            }
        }
        return maxSum;
    }

    // Follow Up Question (To print the subarray)
    /*
    Intuition: Our approach is to store the starting index and the ending index of the subarray. Thus we can easily
    get the subarray afterward without actually storing the subarray elements.

    If we carefully observe our algorithm, we can notice that the subarray always starts at the particular index where
    the sum variable is equal to 0, and at the ending index, the sum always crosses the previous maximum sum(i.e. maxi).

    So, we will keep a track of the starting index inside the loop using a start variable.
    We will take two variables ansStart and ansEnd initialized with -1. And when the sum crosses the maximum sum,
    we will set ansStart to the start variable and ansEnd to the current index i.e. i.
    The rest of the approach will be the same as Kadane’s Algorithm.
     */
    public static long maxSubarraySum(int[] arr, int n) {
        long maxi = Long.MIN_VALUE; // maximum sum
        long sum = 0;

        int start = 0;
        int ansStart = -1, ansEnd = -1;
        for (int i = 0; i < n; i++) {

            if (sum == 0) start = i; // starting index

            sum += arr[i];

            if (sum > maxi) {
                maxi = sum;

                ansStart = start;
                ansEnd = i;
            }

            // If sum < 0: discard the sum calculated
            if (sum < 0) {
                sum = 0;
            }
        }

        //printing the subarray:
        System.out.print("The subarray is: [");
        for (int i = ansStart; i <= ansEnd; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.print("]n");

        // To consider the sum of the empty subarray
        // uncomment the following check:

        //if (maxi < 0) maxi = 0;

        return maxi;
    }

    // Main Function
    public static void main(String[] args) {
        int[] arr = { -2, 1, -3, 4, -1, 2, 1, -5, 4};
        int res = subarraySum(arr);
        System.out.println(res);
    }
}

// Algorithm - Brute Force
/*
1. First, we will run a loop(say i) that will select every possible starting index of the subarray.
   The possible starting indices can vary from index 0 to index n-1(n = size of the array).
2. Inside the loop, we will run another loop(say j) that will signify the ending index of the subarray.
   For every subarray starting from the index i, the possible ending index can vary from index
   i to n-1(n = size of the array).
3. After that for each subarray starting from index i and ending at index j (i.e. arr[i….j]),
   we will run another loop to calculate the sum of all the elements(of that particular subarray).
 */

// Algorithm - Better Solution
/*
1. First, we will run a loop(say i) that will select every possible starting index of the subarray.
   The possible starting indices can vary from index 0 to index n-1(n = array size).
2. Inside the loop, we will run another loop(say j) that will signify the ending index as well as the current
   element of the subarray. For every subarray starting from index i, the possible ending index can vary from index i to n-1(n = size of the array).
3. Inside loop j, we will add the current element to the sum of the previous subarray i.e. sum = sum + arr[j].
   Among all the sums the maximum one will be the answer.
 */

// Algorithm - Optimal Solution
/*
Intuition:
The intuition of the algorithm is not to consider the subarray as a part of the answer if its sum is less than 0.
A subarray with a sum less than 0 will always reduce our answer and so this type of subarray cannot be a part of
the subarray with maximum sum.

Here, we will iterate the given array with a single loop and while iterating we will add the elements in a sum variable.
Now, if at any point the sum becomes less than 0, we will set the sum as 0 as we are not going to consider
any subarray with a negative sum. Among all the sums calculated, we will consider the maximum one.

Thus we can solve this problem with a single loop.

Approach:
The steps are as follows:
1. We will run a loop(say i) to iterate the given array.
2. Now, while iterating we will add the elements to the sum variable and consider the maximum one.
3. If at any point the sum becomes negative we will set the sum to 0 as we are not going to consider it as a part of our answer.
 */

// Striver - https://www.youtube.com/watch?v=AHZpyENo7k4