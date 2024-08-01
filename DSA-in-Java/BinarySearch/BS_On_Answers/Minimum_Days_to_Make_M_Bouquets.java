package BinarySearch.BS_On_Answers;

public class Minimum_Days_to_Make_M_Bouquets {

    // Possible function
    public static boolean possible(int[] arr, int day, int m, int k) {
        int n = arr.length; // Size of the array
        int cnt = 0;
        int noOfB = 0;
        // Count the number of bouquets:
        for (int i = 0; i < n; i++) {
            if (arr[i] <= day) {
                cnt++;
            } else {
                noOfB += (cnt / k);
                cnt = 0;
            }
        }
        noOfB += (cnt / k);
        return noOfB >= m;
    }

    // Main Solution
    public static int roseGarden(int[] arr, int k, int m) {
        long val = (long) m * k;
        int n = arr.length; // Size of the array
        if (val > n) return -1; // Impossible case.
        // Find maximum and minimum:
        int mini = Integer.MAX_VALUE, maxi = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            mini = Math.min(mini, arr[i]);
            maxi = Math.max(maxi, arr[i]);
        }

        // Brute Force
//        for (int i = mini; i <= maxi; i++) {
//            if (possible(arr, i, m, k))
//                return i;
//        }

        // Binary Search Optimization
        int low = mini;
        int high = maxi;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (possible(arr, mid, m, k)) {
                high = mid-1;
            }
            else {
                low = mid+1;
            }
        }
        return low;
    }

    // Main Function
    public static void main(String[] args) {
        int[] arr = {7, 7, 7, 7, 13, 11, 12, 7};
        int k = 3;
        int m = 2;
        int ans = roseGarden(arr, k, m);
        if (ans == -1)
            System.out.println("We cannot make m bouquets.");
        else
            System.out.println("We can make bouquets on day " + ans);
    }
}

// Output -
// We can make bouquets on day 12

// Algorithm : Brute Force
/*
  Time Complexity : O((max(arr[])-min(arr[])+1) * N), where {max(arr[]) -> maximum element of the array, min(arr[]) ->
  minimum element of the array, N = size of the array}.
  Reason: We are running a loop to check our answers that are in the range of [min(arr[]), max(arr[])].
  For every possible answer, we will call the possible() function. Inside the possible() function,
  we are traversing the entire array, which results in O(N).

 Space Complexity : O(1) as we are not using any extra space to solve this problem.
 */

/*
Naive Approach(Brute force):
The extremely naive approach is to check all possible answers from min(arr[]) to max(arr[]). The minimum number for
which possible() returns true, is our answer.

Algorithm:
1. If m*k > arr.size: This means we have insufficient flowers. So, it is impossible to make m bouquets and we will return -1.
2. We will run a loop(say i) from min(arr[]) to max(arr[]) to check all possible answers.
3. Next, we will pass each potential answer, represented by the variable ‘i’ (which corresponds to a specific day), to
 the ‘possible()’ function. If the function returns true, indicating that we can create ‘m’ bouquets, we will return
 the value of ‘i’.
4. Finally, if we are outside the loop, we can conclude that is impossible to make m bouquets. So, we will return -1.
 */

// Algorithm : Optimal Solution
/*
  Time Complexity :  O(log(max(arr[])-min(arr[])+1) * N), where {max(arr[]) -> maximum element of the array, min(arr[])
  -> minimum element of the array, N = size of the array}.
  Reason: We are applying binary search on our answers that are in the range of [min(arr[]), max(arr[])].
  For every possible answer ‘mid’, we will call the possible() function. Inside the possible() function,
  we are traversing the entire array, which results in O(N).

  Space Complexity : O(1) as we are not using any extra space to solve this problem.
 */
/*
Optimal Approach(Using Binary Search):
We are going to use the Binary Search algorithm to optimize the approach.

The primary objective of the Binary Search algorithm is to efficiently determine the appropriate half to eliminate,
thereby reducing the search space by half. It does this by determining a specific condition that ensures that
the target is not present in that half.

Now, we are not given any sorted array on which we can apply binary search. But, if we observe closely,
we can notice that our answer space i.e. [mini(arr[]), max(arr[])] is sorted. So, we will apply binary search
on the answer space.

Algorithm:
1. If m*k > arr.size: This means we have insufficient flowers. So, it is impossible to make m bouquets and we will return -1.
2. Next, we will find the maximum element i.e. max(arr[]), and the minimum element i.e. min(arr[]) in the array.
3. Place the 2 pointers i.e. low and high: Initially, we will place the pointers. The pointer low will point to
   min(arr[]) and the high will point to max(arr[]).
4. Calculate the ‘mid’: Now, inside the loop, we will calculate the value of ‘mid’ using the following formula:
mid = (low+high) // 2 ( ‘//’ refers to integer division)
5. Eliminate the halves based on the value returned by possible():
We will pass the potential answer, represented by the variable ‘mid’ (which corresponds to a specific day), to the ‘possible()’ function.
    1. If possible() returns true: On satisfying this condition, we can conclude that the number ‘mid’ is one of our
    possible answers. But we want the minimum number. So, we will eliminate the right half and consider the left half(i.e. high = mid-1).
    2. Otherwise, the value mid is smaller than the number we want. This means the numbers greater than ‘mid’ should
    be considered and the right half of ‘mid’ consists of such numbers. So, we will eliminate the left half and consider
    the right half(i.e. low = mid+1).
6. Finally, outside the loop, we will return the value of low as the pointer will be pointing to the answer.
The steps from 3-5 will be inside a loop and the loop will continue until low crosses high
 */

// Striver (Video Explanation) : https://youtu.be/TXAuxeYBTdg