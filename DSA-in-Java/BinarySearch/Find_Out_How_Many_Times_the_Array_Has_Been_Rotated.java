package BinarySearch;

public class Find_Out_How_Many_Times_the_Array_Has_Been_Rotated {

    // Method 1 : Brute Force
    // Time - O(N), Space - O(1)
//    static int findRotationCount(int[] arr) {
//        int n = arr.length;
//        int ans = Integer.MAX_VALUE;
//        int idx = -1;
//
//        for (int i=0; i<n; i++) {
//            if (arr[i] < ans) {
//                ans = arr[i];
//                idx = i;
//            }
//        }
//        return idx;
//    }

    // Method 2 : Optimal Solution
    // Time - O(log2N), Space - O(1)
    static int findRotationCount(int[] arr) {
        int n = arr.length;

        int ans = Integer.MAX_VALUE;
        int low = 0;
        int high = n-1;
        int index = -1;

        while (low <= high) {
            int mid = (low + high) / 2;
            //search space is already sorted
            //then arr[low] will always be
            //the minimum in that search space:
            if (arr[low] <= arr[high]) {
                if (arr[low] < ans) {
                    index = low;
                    ans = arr[low];
                }
                break;
            }

            //if left part is sorted:
            if (arr[low] <= arr[mid]) {
                // keep the minimum:
                if (arr[low] < ans) {
                    index = low;
                    ans = arr[low];
                }

                // Eliminate left half:
                low = mid + 1;
            } else { //if right part is sorted:

                // keep the minimum:
                if (arr[mid] < ans) {
                    index = mid;
                    ans = arr[mid];
                }

                // Eliminate right half:
                high = mid - 1;
            }
        }
        return index;
    }

    // Main Function
    public static void main(String[] args) {
        int[] arr = {4, 5, 6, 7, 0, 1, 2, 3};
        int ans = findRotationCount(arr);
        System.out.println("The array is rotated " + ans + " times.");
    }
}

// Output :
/*
The array is rotated 4 times.
 */

// Algorithm : Brute Force
/*
1. First, we will declare an ‘ans’ and an ‘index’ variable initialized with a large number and -1 respectively.
2. Next, we will iterate through the array and compare each element with the variable called ‘ans’. Whenever we
encounter an element ‘arr[i]’ that is smaller than ‘ans’, we will update ‘ans’ with the value of ‘arr[i]’ and
also update the ‘index’ variable with the corresponding index value, ‘i’.
3. Finally, we will return ‘index’ as our answer.
 */

// Algorithm : Optimal Solution
/*
Optimal Approach(Using Binary Search):
We are going to use the binary search algorithm to solve this problem.

The primary objective of the Binary Search algorithm is to efficiently determine the appropriate half to eliminate, thereby reducing the search space by half. It does this by determining a specific condition that ensures that the target is not present in that half.

In the previous article, find the minimum in a rotated sorted array, we have discussed how to find the minimum
element in a rotated and sorted array using Binary search. In this problem, we will employ the same algorithm
to determine the index of the minimum element. In the previous problem, we only stored the minimum element
itself. However, in this updated approach, we will additionally keep track of the index. By making this
small adjustment, we can effectively solve the problem using the existing algorithm.

Algorithm:
The steps are as follows:

To begin, we will declare the variable ‘ans’ and initialize it with the largest possible value. Additionally, we will have two pointers, ‘low’ and ‘high’, as usual. In this case, we will also introduce an ‘index’ variable and initialize it with -1.

1. Place the 2 pointers i.e. low and high: Initially, we will place the pointers like this: low will point to
the first index and high will point to the last index.
2. Calculate the ‘mid’: Now, inside a loop, we will calculate the value of ‘mid’ using the following formula:
mid = (low+high) // 2 ( ‘//’ refers to integer division)
3. If arr[low] <= arr[high]: In this case, the array from index low to high is completely sorted. Therefore,
we can select the minimum element, arr[low].
Now, if arr[low] < ans, we will update ‘ans’ with the value arr[low] and ‘index’ with the corresponding index low.
Once this is done, there is no need to continue with the binary search algorithm. So, we will break from this step.
4. Identify the sorted half, and after picking the leftmost element, eliminate that half.
    1. If arr[low] <= arr[mid]:
       This condition ensures that the left part is sorted. So, we will pick the leftmost element i.e. arr[low].
       Now, if arr[low] < ans, we will update ‘ans’ with the value arr[low] and ‘index’ with the corresponding index low.
       After that, we will eliminate this left half(i.e. low = mid+1).
    2. Otherwise, if the right half is sorted:  This condition ensures that the right half is sorted. So, we will
       pick the leftmost element i.e. arr[mid].
       Now, if arr[mid] < ans, we will update ‘ans’ with the value arr[mid] and ‘index’ with the corresponding index mid.
       After that, we will eliminate this right half(i.e. high = mid-1).
5. This process will be inside a loop and the loop will continue until low crosses high. Finally, we will return the
‘index’ variable that stores the index of the minimum element.
 */

// Striver (Video Explanation) : https://youtu.be/jtSiWTPLwd0

// Striver Video Explanation : https://www.youtube.com/watch?v=nhEMDKMB44g

