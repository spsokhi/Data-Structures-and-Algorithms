package BinarySearch;

public class Find_Minimum_in_Rotated_Sorted_Array {

    // Method 1 : Brute Force
    // Time - O(N), Space - O(1)
//    static int findMinimum(int[] arr) {
//        int n = arr.length;
//        int ans = Integer.MAX_VALUE;
//        for (int i=0; i<n; i++) {
//            if (arr[i] < ans) {
//                ans = arr[i];
//            }
//        }
//        return ans;
//    }

    // Method 2 : Optimal Solution
    // Time - O(log2N), Space - O(1)
    static int findMinimum(int[] arr) {
        int n = arr.length;

        int low = 0;
        int high = n-1;
        int ans = Integer.MAX_VALUE;

        while (low <= high) {
            int mid = (low + high) / 2;

            //if left part is sorted:
            if (arr[low] <= arr[mid]) {
                // keep the minimum:
                ans = Math.min(ans, arr[low]);

                // Eliminate left half:
                low = mid + 1;

            } else { //if right part is sorted:

                // keep the minimum:
                ans = Math.min(ans, arr[mid]);

                // Eliminate right half:
                high = mid - 1;
            }
        }
        return ans;
    }

    // Main Function
    public static void main(String[] args) {
        int[] arr = {4, 5, 6, 7, 0, 1, 2};
        int res = findMinimum(arr);
        System.out.println(res);
    }
}

// Output -
// 0

// Algorithm : Brute Force
// Using Linear Search

// Algorithm : Optimal Solution
/*
1. Place the 2 pointers i.e. low and high: Initially, we will place the pointers like this: low will point to the
first index and high will point to the last index.
2. Calculate the ‘mid’: Now, inside a loop, we will calculate the value of ‘mid’ using the following formula:
mid = (low+high) // 2 ( ‘//’ refers to integer division)
3. Identify the sorted half, and after picking the leftmost element, eliminate that half.
    1. If arr[low] <= arr[mid]: This condition ensures that the left part is sorted. So, we will pick the leftmost
    element i.e. arr[low]. Now, we will compare it with ‘ans’ and update ‘ans’ with the smaller value
    (i.e., min(ans, arr[low])). Now, we will eliminate this left half(i.e. low = mid+1).
    2. Otherwise, if the right half is sorted:  This condition ensures that the right half is sorted. So, we will pick
    the leftmost element i.e. arr[mid]. Now, we will compare it with ‘ans’ and update ‘ans’ with the smaller value
    (i.e., min(ans, arr[mid])). Now, we will eliminate this right half(i.e. high = mid-1).
4. This process will be inside a loop and the loop will continue until low crosses high. Finally, we will return the
   ‘ans’ variable that stores the minimum element.
 */

// Intuition :
/*
Key Observation: If an array is rotated and sorted, we already know that for every index, one of the 2 halves
of the array will always be sorted.

Based on this observation, we adopted a straightforward two-step process to eliminate one-half of the rotated sorted array.

1. First, we identify the sorted half of the array.
2. Once found, we determine if the target is located within this sorted half.
    1. If not, we eliminate that half from further consideration.
    2. Conversely, if the target does exist in the sorted half, we eliminate the other half.
Let’s observe how we identify the sorted half:

We basically compare arr[mid] with arr[low] and arr[high] in the following way:

1. If arr[low] <= arr[mid]: In this case, we identified that the left half is sorted.
2. If arr[mid] <= arr[high]: In this case, we identified that the right half is sorted.

Let’s observe how we will find the minimum element:

In this situation, we have two possibilities to consider. The sorted half of the array may or may not include the
minimum value. However, we can leverage the property of the sorted half, specifically that the leftmost element of
the sorted half will always be the minimum element within that particular half.

During each iteration, we will select the leftmost element from the sorted half and discard that half from further
consideration. Among all the selected elements, the minimum value will serve as our answer.

To facilitate this process, we will declare a variable called ‘ans’ and initialize it with a large number.
Then, at each step, after selecting the leftmost element from the sorted half, we will compare it with ‘ans’
and update ‘ans’ with the smaller value (i.e., min(ans, leftmost_element)).

Note: If, at any index, both the left and right halves of the array are sorted, we have the flexibility to select the
minimum value from either half and eliminate that particular half (in this case, the left half is chosen first).
The algorithm already takes care of this case, so there is no need for explicit handling.
 */

// Edge Cases
// [4, 5, 6, 7, 0, 1, 2]
// bcz the rotation in the right half(thereby it is not sorted)
// If the rotating point on the right half, can i say that the rotating point always have the minimum element
// [7, 8, 1, 2, 3, 4, 5, 6]
// bcz the rotation in the left half(thereby it is not sorted)
// If the rotating point on the left half, can i say that the rotating point always have the minimum element
// [4, 5, 1, 2, 3]
// If the left sorted part never have your answer, then tha right sorted part might have the answer
// {Sorted half may or may not have the answer}

// Striver Video Explanation : https://www.youtube.com/watch?v=nhEMDKMB44g