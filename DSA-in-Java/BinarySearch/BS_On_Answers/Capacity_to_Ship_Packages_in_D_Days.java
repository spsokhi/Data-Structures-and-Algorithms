package BinarySearch.BS_On_Answers;

public class Capacity_to_Ship_Packages_in_D_Days {


    public static int findDays(int[] weights, int cap) {
        int days = 1; // First day.
        int load = 0;
        int n = weights.length; // size of array.
        for (int i = 0; i < n; i++) {
            if (load + weights[i] > cap) {
                days += 1; // move to next day
                load = weights[i]; // load the weight.
            } else {
                // load the weight on the same day.
                load += weights[i];
            }
        }
        return days;
    }

    // Method 1 : Brute Force
    // Time : O(N * (sum(weights[]) – max(weights[]) + 1)), where sum(weights[]) = summation of all the weights,
    // max(weights[]) = maximum of all the weights, N = size of the weights array.
    // Reason: We are using a loop from max(weights[]) to sum(weights[]) to check all possible weights. Inside the
    // loop, we are calling findDays() function for each weight. Now, inside the findDays() function, we are using a
    // loop that runs for N times.
    // Space - O(1), Because no extra space is needed
//    public static int leastWeightCapacity(int[] weights, int d) {
//        //Find the maximum and the summation:
//        int maxi = Integer.MIN_VALUE, sum = 0;
//        for (int i = 0; i < weights.length; i++) {
//            sum += weights[i];
//            maxi = Math.max(maxi, weights[i]);
//        }
//
//        for (int i = maxi; i <= sum; i++) {
//            if (findDays(weights, i) <= d) {
//                return i;
//            }
//        }
//        //dummy return statement:
//        return -1;
//    }

    // Method 2 : Optimal Solution
    // Time : O(N * log(sum(weights[]) – max(weights[]) + 1)), where sum(weights[]) = summation of all the weights,
    // max(weights[]) = maximum of all the weights, N = size of the weights array.
    // Reason: We are applying binary search on the range [max(weights[]), sum(weights[])]. For every possible answer
    // ‘mid’, we are calling findDays() function. Now, inside the findDays() function, we are using a loop that runs for N times.
    public static int leastWeightCapacity(int[] weights, int d) {
        //Find the maximum and the summation:
        int low = Integer.MIN_VALUE, high = 0;
        for (int i = 0; i < weights.length; i++) {
            high += weights[i];
            low = Math.max(low, weights[i]);
        }

        while (low <= high) {
            int mid = (low + high) / 2;
            int numberOfDays = findDays(weights, mid);
            if (numberOfDays <= d) {
                // eliminate right half
                high = mid - 1;
            } else {
                // eliminate left half
                low = mid + 1;
            }
        }
        return low;
    }

    public static void main(String[] args) {
        int[] weights = {5, 4, 5, 2, 3, 4, 5, 6};
        int d = 5;
        int ans = leastWeightCapacity(weights, d);
        System.out.println("The minimum capacity should be: " + ans);
    }
}

// Output :
// The minimum capacity should be: 9

// Algorithm : Brute Force
/*
Naive Approach:
The extremely naive approach is to check all possible capacities from max(weights[]) to sum(weights[]).
The minimum number for which the required days <= d value, will be our answer.

Algorithm:
1. We will use a loop(say cap) to check all possible capacities.
2. Next, inside the loop, we will send each capacity to the findDays() function to get the number of days required for
that particular capacity.
3. The minimum number, for which the number of days <= d, will be the answer.
 */

// Algorithm : Optimal Solution
/*
Optimal Approach(Using Binary Search):
We are going to use the Binary Search algorithm to optimize the approach.

The primary objective of the Binary Search algorithm is to efficiently determine the appropriate half to eliminate,
thereby reducing the search space by half. It does this by determining a specific condition that ensures that the
target is not present in that half.

Now, we are not given any sorted array on which we can apply binary search. Upon closer observation, we can recognize
that our answer space, represented as [max(weights[]), sum(weights[])], is actually sorted. Additionally, we can
identify a pattern that allows us to divide this space into two halves: one consisting of potential answers and the
other of non-viable options. So, we will apply binary search on the answer space.

Algorithm:
1. First, we will find the maximum element i.e. max(weights[]), and the summation i.e. sum(weights[]) of the given array.
2. Place the 2 pointers i.e. low and high: Initially, we will place the pointers. The pointer low will point to
max(weights[]) and the high will point to sum(weights[]).
3. Calculate the ‘mid’: Now, inside the loop, we will calculate the value of ‘mid’ using the following formula:
mid = (low+high) // 2 ( ‘//’ refers to integer division)
4. Eliminate the halves based on the number of days required for the capacity ‘mid’:
We will pass the potential capacity, represented by the variable ‘mid’, to the ‘findDays()‘ function. This function
will return the number of days required to ship all the weights for the particular capacity, ‘mid’.
    1. If numberOfDays <= d: On satisfying this condition, we can conclude that the number ‘mid’ is one of our possible
    answers. But we want the minimum number. So, we will eliminate the right half and consider the left half(i.e. high = mid-1).
    2. Otherwise, the value mid is smaller than the number we want. This means the numbers greater than ‘mid’ should be
    considered and the right half of ‘mid’ consists of such numbers. So, we will eliminate the left half and consider
    the right half(i.e. low = mid+1).
5. Finally, outside the loop, we will return the value of low as the pointer will be pointing to the answer.
The steps from 3-4 will be inside a loop and the loop will continue until low crosses high.
 */

// Striver (Video Explanation) : https://youtu.be/MG-Ac4TAvTY?si=GHwXpGWd6Fd3OJCP