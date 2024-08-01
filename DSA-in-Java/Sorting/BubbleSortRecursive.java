package Sorting;

public class BubbleSortRecursive {


    // Bubble Sort Recursive Function
    public static void bubbleSort(int[] arr, int n) {
        // Base Case: range == 1.
        if(n == 1) {
            return;
        }

        for(int i=0; i<n-1; i++) {
            if(arr[i] > arr[i+1]) {
                // Swap
                int temp = arr[i];
                arr[i] = arr[i+1];
                arr[i+1] = temp;
            }
        }

        //Range reduced after recursion:
        bubbleSort(arr, n-1);
    }

    // Print array function
    static void printArray(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    // Main Function
    public static void main(String[] args) {
        // Create an Object of Bubble Sort Class
        BubbleSort bs = new BubbleSort();
        int[] arr = {2,8,9,1,4};
        bs.bubbleSort(arr);
        bs.printArray(arr);
    }
}

// In Bubble Sort - Push the maximum element to the last, using adjacent swaps

// Output:
// 1 2 4 8 9

// Algorithm (Approach) ->
/*
The approach will be the following:

1. First, call the recursive function with the given array and the range of n(size of the array).
2. Inside that recursive function, repeatedly swap 2 adjacent elements if arr[j] > arr[j+1].
   Here, the maximum element of the unsorted array reaches the end of the unsorted array after
   each recursive call.
3. Each time after step 2, call the recursion again decreasing the range by 1.
4. The recursion will continue until the range(i.e. the size) of the array is reduced to 1.
   Base Case: if(n == 1) return;
 */

// Time & Space Complexity
/*
Time Complexity: O(N2), (where N = size of the array), for the worst, and average cases.

Reason: If we carefully observe, we can notice that the recursion call, is occurring for n times,
and for each recursion call, the loop j runs from 0 to n-2. For, the range of size n,
the inner loop runs n-1 times, for the range of size n-1, the inner loop runs n-2 times,
and so on. So, the total steps will be approximately the
following: (n-1) + (n-2) + (n-3) + ……..+ 3 + 2 + 1.
The summation is approximately the sum of the first n natural numbers i.e. (n*(n+1))/2.
The precise time complexity will be O(n2/2 + n/2). Previously, we have learned that we can
ignore the lower values as well as the constant coefficients. So, the time complexity is O(n2).
Here the value of n is N i.e. the size of the array.

Space Complexity: O(N) auxiliary stack space.
 */

// Striver - https://takeuforward.org/arrays/recursive-bubble-sort-algorithm/