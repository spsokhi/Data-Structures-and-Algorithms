package BinarySearch.BS_On_Answers;

public class Koko_Eating_Bananas {

    // Find Maximum Element Function
    static int findMaximumElement(int[] arr) {
        int n = arr.length;
        int maxi = Integer.MIN_VALUE;

        for (int i=0; i<n; i++) {
            if (arr[i] > maxi) {
                maxi = arr[i];
            }
        }
        return maxi;
    }

    // Calculate Total Hours Function
    static int calculateTotalHours(int[] arr, int hourly) {
        int n = arr.length;
        int totalHours = 0;

        for (int i=0; i<n; i++) {
            totalHours += (int) Math.ceil((double) arr[i] / (double) hourly);
        }
        return totalHours;
    }

    // Method 1 : Brute Force
    // Time : O(N) * O(max(arr)), Space - O(1)
//    static int minimumRateToEatBananas(int[] arr, int hours) {
//        int n = arr.length;
//
//        int maxElement = findMaximumElement(arr);
//
//        for (int i=1; i<=maxElement; i++) {
//            int reqTime = calculateHours(arr, i);
//            if (reqTime <= hours) {
//                return i;
//            }
//        }
//        return maxElement;
//    }

    // Method 2 : Optimal Solution
    // Time - O(N) * O(log2(maxElement)), Space - O(1)
    static int minimumRateToEatBananas(int[] arr, int hours) {
        int low = 1;
        int high = findMaximumElement(arr);

        while (low <= high) {
            int mid = (low + high) / 2;
            int reqTime = calculateTotalHours(arr, mid);
            if (reqTime <= hours) {
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
        int[] arr = {7, 15, 6, 3};
        int h = 8;
        int ans = minimumRateToEatBananas(arr, h);
        System.out.println("Koko should eat at least " + ans + " bananas/hr.");
    }
}

// Output -
// Koko should eat at least 5 bananas/hr.

// Algorithm : Brute Force
/*
The extremely naive approach is to check all possible answers from 1 to max(a[]). The minimum number for which
the required time <= h, is our answer.

Algorithm:

1. First, we will find the maximum value i.e. max(a[]) in the given array.
2. We will run a loop(say i) from 1 to max(a[]), to check all possible answers.
3. For each number i, we will calculate the hours required to consume all the bananas from the pile. We will do
this using the function calculateTotalHours(), discussed below.
4. The first i, for which the required hours <= h, we will return that value of i.

calculateTotalHours(a[], hourly):

i. a[] -> the given array
11. Hourly -> the possible number of bananas, Koko will eat in an hour.

1. We will iterate every pile of the given array using a loop(say i).
2. For every pile i, we will calculate the hour i.e. ceil(v[i] / hourly), and add it to the total hours.
3. Finally, we will return the total hours.
 */

// Algorithm : Optimal Solution
/*
Now, we are not given any sorted array on which we can apply binary search. But, if we observe closely, we can notice
that our answer space i.e. [1, max(a[])] is sorted. So, we will apply binary search on the answer space.

Algorithm:
1. First, we will find the maximum element in the given array i.e. max(a[]).
2. Place the 2 pointers i.e. low and high: Initially, we will place the pointers. The pointer low will point to 1 and
the high will point to max(a[]).
3. Calculate the ‘mid’: Now, inside the loop, we will calculate the value of ‘mid’ using the following formula:
mid = (low+high) // 2 ( ‘//’ refers to integer division)
4. Eliminate the halves based on the time required if Koko eats ‘mid’ bananas/hr:
We will first calculate the total time(required to consume all the bananas in the array) i.e. totalH using the function
calculateTotalHours(a[], mid):
    1. If totalHours <= h: On satisfying this condition, we can conclude that the number ‘mid’ is one of our possible
    answers. But we want the minimum number. So, we will eliminate the right half and consider the left half(i.e. high = mid-1).
    2. Otherwise, the value mid is smaller than the number we want(as the totalH > h). This means the numbers greater
    than ‘mid’ should be considered and the right half of ‘mid’ consists of such numbers. So, we will eliminate the
    left half and consider the right half(i.e. low = mid+1).
5. Finally, outside the loop, we will return the value of low as the pointer will be pointing to the answer.
The steps from 2-4 will be inside a loop and the loop will continue until low crosses high.
 */

// Striver (Video Explanation) : https://youtu.be/qyfekrNni90