package Sorting;

public class QuickSort {

    // Partition Function
    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[low];
        // i find the greatest element than pivot in each iteration
        int i = low + 1; // Start from the element next to pivot
        // j find the smallest element than pivot in each iteration
        int j = high;

        while (i <= j) {
            while (i <= j && arr[i] <= pivot) {
                i++;
            }
            while (arr[j] > pivot) {
                j--;
            }
            if (i < j) {
                swap(arr, i, j);
            }
        }
        // Swap pivot with the element at position j
        swap(arr, low, j);
        return j; // Return the pivot's final position
    }

    // Swap Function
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // QuickSort Function
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(arr, low, high);
            // Recursively sort elements before and after partition
            quickSort(arr, low, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, high);
        }
    }

    // Print Method (Print all the sorted elements)
    static void printArray(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; ++i) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    // Main Function
    public static void main(String[] args) {
        int[] arr = {2, 8, 9, 1, 4};
        quickSort(arr, 0, arr.length - 1);
        printArray(arr);
    }
}

// QuickSort is a sorting algorithm based on the Divide and Conquer algorithm that picks
// an element as a pivot and partitions the given array around the picked pivot by placing
// the pivot in its correct position in the sorted array

// Algorithms (Approach) ->
/*
1. Set pivot as the element at index low in the array arr.
2. Initialize i as the value of low and j as the value of high.
3. Start a while loop with the condition i < j.
4. Inside the loop:
    1. Increment i until arr[i] is greater than the pivot or until i reaches the index high.
    2. Decrement j until arr[j] is less than or equal to the pivot.
    3. If i is still less than j, swap the elements at indices i and j in the array arr.
5. Outside the loop:
6. Swap the pivot element (arr[low]) with the element at index j in the array arr.

Example ->

Return the value of j as the final position of the pivot element.
Let's go through an example using the array [7, 2, 1, 6, 8, 5], low as 0, and high as 5:

1. Set pivot as 7 (element at index low).
2. Initialize i = 0 and j = 5.
3. Enter the while loop.
4. Increment i to 1.
5. Decrement j to 4.
6. Swap elements arr[1] and arr[4], resulting in [7, 8, 1, 6, 2, 5].
7. Increment i to 2.
8. Decrement j to 3.
9. Swap elements arr[2] and arr[3], resulting in [7, 8, 6, 1, 2, 5].
10. Increment i to 3.
11. Decrement j to 2.
12. The loop condition i < j is no longer satisfied, so exit the loop.
13. Swap the pivot element (arr[low]) with the element at index j, resulting in [6, 8, 7, 1, 2, 5].
Return the value of j, which is 2.
14. After the partitioning process, the array is partitioned into two halves: [6, 1, 2, 5] and [8, 7]. The pivot element (7) is now in its correct sorted position, with all elements to its left being smaller and all elements to its right being greater.
 */

/* Time & Space Complexity -
    Worst complexity: O(n^2)
    Average complexity: O[n*log(n)]
    Best complexity: O[n*log(n)]
    Space complexity: O[(log(n)]
 */

// Anuj Bhaiya - https://www.youtube.com/watch?v=UA_Rmjfj4bw