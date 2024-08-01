package BinarySearch.BS_On_Answers;

import java.util.Arrays;

public class Aggressive_Cows {

    // Method 1 : Brute Force
    // Time : O(max(arr) - min(arr)) * O(N)
    // Space : O(1) as we are not using any extra space to solve this problem.
//    static int aggressiveCows(int[] stalls, int k) {
//        int n = stalls.length;
//        Arrays.sort(stalls);
//
//        int limit = stalls[n-1] - stalls[0];
//        for (int i=1; i<= limit; i++) {
//            if (canWePlace(stalls, i, k) == false) {
//                return (i-1);
//            }
//        }
//        return limit;
//    }

    // canWePlace function is used to check cows is perfectly placed or not
    static boolean canWePlace(int[] stalls, int dist, int cows) {
        int n = stalls.length;

        int cntCows = 1;
        int last = stalls[0];

        for (int i=1; i<n; i++) {
            if (stalls[i] - last >= dist) {
                cntCows++;
                last = stalls[i];
            }
            if (cntCows >= cows) return true;
        }
        return false;
    }

    // Method 2 : Optimal Solution
    // Time : O(NlogN) + O(N * log(max(stalls[])-min(stalls[]))), where N = size of the array, max(stalls[]) = maximum
    // element in stalls[] array, min(stalls[]) = minimum element in stalls[] array.
    // Reason: O(NlogN) for sorting the array. We are applying binary search on [1, max(stalls[])-min(stalls[])].
    // Inside the loop, we are calling canWePlace() function for each distance, ‘mid’. Now, inside the canWePlace()
    // function, we are using a loop that runs for N times.
    // Space : O(1) as we are not using any extra space to solve this problem.
    static int aggressiveCows(int[] stalls, int k) {
        int n = stalls.length;
        Arrays.sort(stalls);

        int low = 1;
        int high = stalls[n-1] - stalls[0];
        while (low <= high) {
            int mid = (low + high)/2;
            if (canWePlace(stalls, mid, k)) {
                low = mid+1;
            }
            else {
                high = mid-1;
            }
        }
        return high;
    }

    // Main Function
    public static void main(String[] args) {
        int[] stalls = {0, 3, 4, 7, 10, 9};
        int k = 4;
        int ans = aggressiveCows(stalls, k);
        System.out.println("The maximum possible minimum distance is: " + ans);
    }
}

// Output :
// The maximum possible minimum distance is: 3

// Algorithm : Brute Force
/*
Naive Approach:
The extremely naive approach is to check all possible distances from 1 to max(stalls[])-min(stalls[]).
The maximum distance for which the function canWePlace() returns true, will be our answer.

Algorithm:
1. First, we will sort the given stalls[] array.
2. We will use a loop(say i) to check all possible distances.
3. Next, inside the loop, we will send each distance, i, to the function canWePlace() function to check if it is possible
to place the cows.
    1. We will return (i-1), where i is the minimum distance for which the function canWePlace() returns false. Because (i-1)
    is the maximum distance for which we can place all the cows and for the distances >= i, it becomes impossible.
4. Finally, if we are outside the loop, we can conclude the minimum possible distance should be max(stalls[])-min(stalls[]).
   And we will return this value.
 */

// Algorithm : Optimal Solution
/*
Algorithm / Intuition
Optimal Approach(Using Binary Search):
We are going to use the Binary Search algorithm to optimize the approach.

The primary objective of the Binary Search algorithm is to efficiently determine the appropriate half to eliminate,
thereby reducing the search space by half. It does this by determining a specific condition that ensures that the
target is not present in that half.

Upon closer observation, we can recognize that our answer space, represented as [1, (max(stalls[])-min(stalls[]))],
is actually sorted. Additionally, we can identify a pattern that allows us to divide this space into two halves:
one consisting of potential answers and the other of non-viable options. So, we will apply binary search on the answer space.

Algorithm:
1. First, we will sort the given stalls[] array.
2. Place the 2 pointers i.e. low and high: Initially, we will place the pointers. The pointer low will point to 1 and
the high will point to (stalls[n-1]-stalls[0]). As the ‘stalls[]’ is sorted, ‘stalls[n-1]’ refers to the maximum, and
‘stalls[0]’ is the minimum element.
3. Calculate the ‘mid’: Now, inside the loop, we will calculate the value of ‘mid’ using the following formula:
mid = (low+high) // 2 ( ‘//’ refers to integer division)
4. Eliminate the halves based on the boolean value returned by canWePlace():
We will pass the potential distance, represented by the variable ‘mid’, to the ‘canWePlace()‘ function. This function
will return true if it is possible to place all the cows with a minimum distance of ‘mid’.
    1. If the returned value is true: On satisfying this condition, we can conclude that the number ‘mid’ is one of our
    possible answers. But we want the maximum number. So, we will eliminate the left half and consider the right half(i.e. low = mid+1).
    2. Otherwise, the value mid is greater than the distance we want. This means the numbers greater than ‘mid’ should
    not be considered and the right half of ‘mid’ consists of such numbers. So, we will eliminate the right half and consider the left half(i.e. high = mid-1).
5. Finally, outside the loop, we will return the value of high as the pointer will be pointing to the answer.
The steps from 3-4 will be inside a loop and the loop will continue until low crosses high.
 */

// Striver (Video Explanation) : https://youtu.be/R_Mfw4ew-Vo