package BinarySearch;

public class Find_Peak_Element {

    // Method 1 : Brute Force
    // Time - O(N), Space - O(1)
    static int findPeak(int[] arr) {
        int n = arr.length;

        if (n == 0) return 0;
        if (arr[0] > arr[1]) return 0;
        if (arr[n-1] > arr[n-2]) return n-1;

        for (int i=1; i<=n-2; i++) {
            if (arr[i] > arr[i-1] && arr[i] > arr[i+1]) {
                return i;
            }
        }
        return -1;
    }

    // Method 2 : Optimal Solution
    // Time - O(log2N), Space - O(1)
    static int findPeak2(int[] arr) {
        int n = arr.length;

        // Seperate edge case for first and last element
        if (n == 1) return 0;
        if (arr[0] > arr[1]) return 0;
        if (arr[n-1] > arr[n-2]) return n-1;

        int low = 1;
        int high = n-2;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (arr[mid] > arr[mid-1] && arr[mid] > arr[mid+1]) {
                return mid;
            }
            // check if the mid element is greater than mid - 1 element
            // then we know that the left part is sorted and that not contain my peak element
            // so, low moves to low = mid + 1
            if (arr[mid] > arr[mid-1]) {
                low = mid+1;
            }
            // then we know that the left part is sorted and that not contain my peak element
            // so, high moves to high = mid - 1
            else {
                high = mid-1;
            }
        }
        return -1;
    }

    // Main Function
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,5,1};
        int res = findPeak2(arr);
        System.out.println(res);
    }
}

// Output -
// 1

// Problem Statement: Given an array of length N. Peak element is defined as the element greater than both of its
// neighbors. Formally, if ‘arr[i]’ is the peak element, ‘arr[i – 1]’ < ‘arr[i]’ and ‘arr[i + 1]’ < ‘arr[i]’.
// Find the index(0-based) of a peak element in the array. If there are multiple peak numbers, return the
// index of any peak number.
// Note: For the first element, the previous element should be considered as negative infinity as well as for
// the last element, the next element should be considered as negative infinity.

// Examples :
/*
Example 1:
Input Format: arr[] = {1,2,3,4,5,6,7,8,5,1}
Result: 7
Explanation: In this example, there is only 1 peak that is at index 7.

Example 2:
Input Format: arr[] = {1,2,1,3,5,6,4}
Result: 1
Explanation: In this example, there are 2 peak numbers that are at indices 1 and 5. We can consider any of them.

Example 3:
Input Format: arr[] = {1, 2, 3, 4, 5}
Result: 4
Explanation: In this example, there is only 1 peak that is at the index 4.

Example 4:
Input Format: arr[] = {5, 4, 3, 2, 1}
Result: 0
Explanation: In this example, there is only 1 peak that is at the index 0.
 */

// Algorithm : Brute Force
/*
1. Traverse the array from start to end.
2. Check if the current element is greater than both of its neighbors.
3. Seperate checking for first and last element.
3. If yes, then return the index of the current element.
4. If not, then move to the next element.
5. If no peak element found, then return -1.

Note : Linear Search
 */

// Intuition : Optimal Solution
/*
By observing the above example 1, we can clearly notice a striking distinction between the left and right
halves of the peak element in the array.

The left half of the peak element has an increasing order. This means for every index i, arr[i-1] < arr[i].
On the contrary, the right half of the peak element has a decreasing order. This means for every index i,
arr[i+1] < arr[i].
Now, using the above observation, we can easily identify the left and right halves, just by checking the
property of the current index, i, like the following:

If arr[i] > arr[i-1]: we are in the left half.
If arr[i] > arr[i+1]: we are in the right half.
How to eliminate the halves accordingly:

If we are in the left half of the peak element, we have to eliminate this left half (i.e.
low = mid+1). Because our peak element appears somewhere on the right side.
If we are in the right half of the peak element, we have to eliminate this right half (i.e. high = mid-1).
Because our peak element appears somewhere on the left side.

Now, let’s see if these conditions are enough to handle the array with multiple peaks. Based on the observation,
in an array with multiple peaks, an index has four possible positions as follows:

The index is a common point where a decreasing sequence ends and an increasing sequence begins.
The index might be on the left half.
The index might be the peak itself.
The index might be on the right half.

Until now, we have found how to identify if an element is a peak and how to identify the halves and then
eliminate them accordingly. So, the last 3 cases have been resolved. We have to find out how the first case
should be handled.

If an index is a common point where a decreasing sequence ends and an increasing sequence begins, we can
actually eliminate either the left or right half. Because both halves of such an index contain a peak.

So, we decide to merge this case with the condition If arr[i+1] < arr[i]. You can choose otherwise as well.
 */

// Algorithm : Optimal Solution
/*
Algorithm:
Note: At the start of the algorithm, we address the edge cases of identifying the peak element without requiring
separate conditions during the check for arr[mid] inside the loop. And the search space will be from index 1 to n-2
as indices 0 and n-1 have already been checked in the edge cases.

The final steps will be as follows:

1. If n == 1: This means the array size is 1. If the array contains only one element, we will return that index i.e. 0.
2. If arr[0] > arr[1]: This means the very first element of the array is the peak element. So, we will return the index 0.
3. If arr[n-1] > arr[n-2]: This means the last element of the array is the peak element. So, we will return the index n-1.
4. Place the 2 pointers i.e. low and high: Initially, we will place the pointers excluding index 0 and n-1 like this:
low will point to index 1, and high will point to index n-2 i.e. the second last index.
5. Calculate the ‘mid’: Now, inside a loop, we will calculate the value of ‘mid’ using the following formula:
mid = (low+high) // 2 ( ‘//’ refers to integer division)
6. Check if arr[mid] is the peak element:
If arr[mid] > arr[mid-1] and arr[mid] > arr[mid+1]: If this condition is true for arr[mid], we can conclude arr[mid]
is the peak element. We will return the index ‘mid’.
7. If arr[mid] > arr[mid-1]: This means we are in the left half and we should eliminate it as our peak element appears
 on the right. So, we will do this:
    low = mid+1.
8. Otherwise, we are in the right half and we should eliminate it as our peak element appears on the left. So, we will
do this:
    high = mid-1.
This case also handles the case for the index ‘mid’ being a common point of a decreasing and increasing sequence.
It will consider the left peak and eliminate the right peak.

The steps from 5 to 8 will be inside a loop and the loop will continue until low crosses high.
 */

// Striver Video Explanation : https://www.youtube.com/watch?v=cXxmbemS6XM