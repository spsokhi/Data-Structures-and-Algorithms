package BinarySearch.BS_On_Answers;

public class Kth_Missing_Positive_Number {

    // Method 1 : Brute Force
    // Time : O(N), Space : O(1)
//    static int kthMissing(int[] arr, int k) {
//        int n = arr.length;
//
//        for (int i=0; i<n; i++) {
//            if (arr[i] < k) k++;
//            else break;
//        }
//        return k;
//    }

    // Method 2 : Optimal Solution
    // Time : O(log2N), Space : O(1)
    static int kthMissing(int[] arr, int k) {
        int n = arr.length;

        int low = 0;
        int high = n-1;
        while (low <= high) {
            int mid = (low + high) / 2;
            int missing = arr[mid] - (mid + 1);
            if (missing < k) {
                low = mid+1;
            }
            else {
                high = mid-1;
            }
        }
        return high + k + 1;
    }

    // Main Function
    public static void main(String[] args) {
        int[] arr = {4, 7, 9, 10};
        int k = 4;
        int ans = kthMissing(arr, k);
        System.out.println("The missing number is: " + ans);
    }
}

// Examples :
/*
Example 1:
Input Format: arr[]={4,7,9,10}, k = 1
Result: 1
Explanation: The missing numbers are 1, 2, 3, 5, 6, 8, 11, 12, ……, and so on. Since 'k' is 1, the first missing
element is 1.

Example 2:
Input Format: arr[]={4,7,9,10}, k = 4
Result: 5
Explanation: The missing numbers are 1, 2, 3, 5, 6, 8, 11, 12, ……, and so on. Since 'k' is 4, the fourth missing
element is 5.
 */

// Output :
// The missing number is: 5

// Algorithm : Brute Force
/*
Naive Approach:
There might be many brute-force approaches to solve this problem. But we are going to use the following simple
steps to solve the problem.

Algorithm:
1. We will use a loop to traverse the array.
2. Inside the loop,
    1. If arr[i] <= k: we will simply increase the value of k by 1.
    2. Otherwise, we will break out of the loop.
3. Finally, we will return the value of k.

Note: The main idea is to shift k by 1 step if the current element is smaller or equal to k. And whenever we get a
number > k, we can conclude that k is the missing number.
 */

// Algorithm : Optimal Solution
/*
Intuition
We cannot apply binary search on the answer space here as we cannot assure which missing number has the possibility of
being the kth missing number. That is why, we will do something different here. We will try to find the closest
neighbors (i.e. Present in the array) for the kth missing number by counting the number of missing numbers for each
element in the given array.

Let’s understand it using an example. Assume the given array is {2, 3, 4, 7, 11}. Now, if no numbers were missing the
given array would look like {1, 2, 3, 4, 5}. Comparing these 2 arrays, we can conclude the following:

Up to index 0: Only 1 number i.e. 1 is missing in the given array.
Up to index 1: Only 1 number i.e. 1 is missing in the given array.
Up to index 2: Only 1 number i.e. 1 is missing in the given array.
Up to index 3: 3 numbers i.e. 1, 5, and 6 are missing.
Up to index 4: 6 numbers i.e. 1, 5, 6, 8, 9, and 10 are missing.

For a given value of k as 5, we can determine that the answer falls within the range of 7 to 11. Since there are only 3
missing numbers up to index 3, the 5th missing number cannot be before vec[3], which is 7. Therefore, it must be
located somewhere to the right of 7. Our actual answer i.e. 9 also supports this theory. So, by following this process
we can find the closest neighbors (i.e. Present in the array) for the kth missing number. In our example, the closest
neighbors of the 5th missing number are 7 and 11.

How to calculate the number of missing numbers for any index i?

From the above example, we can derive a formula to find the number of missing numbers before any array index, i. The formula is
Number of missing numbers up to index i = vec[i] - (i+1).
The given array, vec, is currently containing the number vec[i] whereas it should contain (i+1) if no numbers were missing. The difference between the current and the ideal element will give the result.

How to apply Binary Search?

We will apply binary search on the indices of the given array. For each index, we will calculate the number of missing numbers and based on it, we will try to eliminate the halves.

How we will get the answer after all these steps?

After completing the binary search on the indices, the pointer high will point to the closest neighbor(present in the
array) that is smaller than the kth missing number.

So, in the given array, the preceding neighbor of the kth missing number is arr[high].
Now, we know, up to index ‘high’,
the number of missing numbers = arr[high] - (high+1).
But we want to go further and find the kth number. To extend our objective, we aim to find the kth number in the
sequence. In order to determine the number of additional missing values required to reach the kth position,

we can calculate this as
more_missing_numbers = k - (arr[high] - (high+1)).
Now, we will simply add more_missing_numbers to the preceding neighbor i.e. vec[high] to get the kth missing number.
kth missing number = arr[high] + k - (arr[high] - (high+1))
        =  arr[high] + k - arr[high] + high + 1
        = k + high + 1.

Algorithm:
1. Place the 2 pointers i.e. low and high: Initially, we will place the pointers. The pointer low will point to index 0
and the high will point to index n-1 i.e. the last index.
2. Calculate the ‘mid’: Now, inside the loop, we will calculate the value of ‘mid’ using the following formula:
mid = (low+high) // 2 ( ‘//’ refers to integer division)
3. Eliminate the halves based on the number of missing numbers up to index ‘mid’:
We will calculate the number of missing numbers using the above-said formula like this: missing_numbers = arr[mid] - (mid+1).
    1. If missing_numbers < k: On satisfying this condition, we can conclude that we are currently at a smaller index.
    But we want a larger index. So, we will eliminate the left half and consider the right half(i.e. low = mid+1).
    2. Otherwise, we have to consider smaller indices. So, we will eliminate the right half and consider the left
    half(i.e. high = mid-1).
4. Finally, when we are outside the loop, we will return the value of (k+high+1) i.e. the kth missing number.
The steps from 2-3 will be inside a loop and the loop will continue until low crosses high.
 */

// Striver (Video Explanation) : https://youtu.be/uZ0N_hZpyps?si=Ml8Zp95fgjyW-zmg