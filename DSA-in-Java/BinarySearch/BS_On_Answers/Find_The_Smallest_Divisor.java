package BinarySearch.BS_On_Answers;

public class Find_The_Smallest_Divisor {

    // Method 1 : Brute Force
    // Time : O(max(arr)) * O(N)
    // Reason: We are using nested loops. The outer loop runs from 1 to max(arr[]) and the inner loop runs for N times.
    // Space - O(1) no extra space is needed
//    static int smallestDivisor(int[] arr, int limit) {
//        int n = arr.length;
//        int maxi = Integer.MIN_VALUE;
//        for (int i=0; i<n; i++) {
//            maxi = Math.max(arr[i], maxi);
//        }
//
//        for (int d=1; d<=maxi; d++) {
//            int sum = 0;
//            for (int i = 0; i < n; i++) {
//                sum += Math.ceil((double)(arr[i]) / (double)(d));
//            }
//            if (sum <= limit)
//                return d;
//        }
//        return -1;
//    }

    // Sum by Divisor Function
    public static int sumByD(int[] arr, int div) {
        int n = arr.length; //size of array
        //Find the summation of division values:
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += (int) Math.ceil((double)(arr[i]) / (double)(div));
        }
        return sum;
    }

    // Method 2 : Optimal Solution (Suing Binary Search)
    // Time - O(log2(max(arr))) * O(N)
    // Reason: We are applying binary search on our answers that are in the range of [1, max(arr[])]. For every
    // possible divisor ‘mid’, we call the sumByD() function. Inside that function, we are traversing the
    // entire array, which results in O(N).
    // Space - O(1) no extra space is needed
    static int smallestDivisor(int[] arr, int limit) {
        int n = arr.length;
        if(n > limit) return -1;
        int maxi = Integer.MIN_VALUE;
        for (int i=0; i<n; i++) {
            maxi = Math.max(arr[i], maxi);
        }

        int low = 1;
        int high = maxi;

        while (low <= high) {
            int mid = (low + high)/2;
            int res = sumByD(arr, mid);
            if (res <= limit) {
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
        int[] arr = {8,4,2,3};
        int limit = 10;
        int ans = smallestDivisor(arr, limit);
        System.out.println("The minimum divisor is: " + ans);
    }
}

// Output -
// The minimum divisor is: 2

// Algorithm : Brute Force
/*
Naive Approach(Brute-force):
The extremely naive approach is to check all possible divisors from 1 to max(arr[]). The minimum number for
which the result <= threshold value, will be our answer.

Algorithm:
1. We will run a loop(say d) from 1 to max(arr[]) to check all possible divisors.
2. To calculate the result, we will iterate over the given array using a loop. Within this loop, we will
divide each element in the array by the current divisor, d, and sum up the obtained ceiling values.
3. Inside the outer loop, If result <= threshold: We will return d as our answer.
4. Finally, if we are outside the nested loops, we will return -1.
 */

// Algorithm : Optimal Solution
/*
Now, we are not given any sorted array on which we can apply binary search. Upon closer observation, we can recognize that our answer space, represented as [1, max(arr[])], is actually sorted. Additionally, we can identify a pattern that allows us to divide this space into two halves: one consisting of potential answers and the other of non-viable options. So, we will apply binary search on the answer space.

Algorithm:
1. If n > threshold: If the minimum summation i.e. n > threshold value, the answer does not exist. In this case, we will return -1.
2. Next, we will find the maximum element i.e. max(arr[]) in the given array.
3. Place the 2 pointers i.e. low and high: Initially, we will place the pointers. The pointer low will point to 1 and the high will point to max(arr[]).
4. Calculate the ‘mid’: Now, inside the loop, we will calculate the value of ‘mid’ using the following formula:
    mid = (low+high) // 2 ( ‘//’ refers to integer division)
5. Eliminate the halves based on the summation of division results:
We will pass the potential divisor, represented by the variable ‘mid’, to the ‘sumByD()‘ function. This function will return the summation result of the division values.
    1. If result <= threshold: On satisfying this condition, we can conclude that the number ‘mid’ is one of our possible answers. But we want the minimum number. So, we will eliminate the right half and consider the left half(i.e. high = mid-1).
    2. Otherwise, the value mid is smaller than the number we want. This means the numbers greater than ‘mid’ should be considered and the right half of ‘mid’ consists of such numbers. So, we will eliminate the left half and consider the right half(i.e. low = mid+1).
6. Finally, outside the loop, we will return the value of low as the pointer will be pointing to the answer.
The steps from 3-4 will be inside a loop and the loop will continue until low crosses high.

The algorithm for sumByD() is given below:

sumByD(arr[], div):

arr[] -> the given array, div -> the divisor.

1. We will run a loop to iterate over the array.
2. We will divide each element by ‘div’, and consider the ceiling value.
3. With that, we will sum up the ceiling values as well.
4. Finally, we will return the summation.
 */

// Striver (Video Explanation) : https://youtu.be/xvNwoz-ufXA