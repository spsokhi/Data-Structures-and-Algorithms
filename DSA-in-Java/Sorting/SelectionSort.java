package Sorting;

public class SelectionSort {

    // Selection Sort Function
    public static void selectionSort(int[] arr) {
        // One by one move boundary of unsorted subArray
        for (int i=0; i<arr.length-1; i++) {
            // Find the minimum element in unsorted array
            int minElementIndex = i;
            for (int j=i+1; j< arr.length; j++) {
                if (arr[j] < arr[minElementIndex]) {
                    minElementIndex = j;
                }
            }
            // Swapping
            // swap the smallest element with the element at i
//            if (minElementIndex != i) {
//                int temp = arr[i];
//                arr[i] = arr[minElementIndex];
//                arr[minElementIndex] = temp;
//            }
            int temp = arr[i];
            arr[i] = arr[minElementIndex];
            arr[minElementIndex] = temp;
        }
    }

    // Print Array Function
    public static void printArray(int[] arr) {
        for (int i=0; i<arr.length; ++i)
            System.out.print(arr[i]+" ");
        System.out.println();
    }

    // Main Function
    public static void main(String[] args) {
        int[] arr = {7,8,1,3,2};
        selectionSort(arr);
        printArray(arr);
    }
}

// In Selection Sort (idea) - Find the minimum elements from an array, and swap with its correct position

// Output
/*
1 2 3 7 8
 */

// Algorithms (approach)
/*
1.  Initialize minimum value(min_idx) to location 0
2.  Traverse the array to find the minimum element in the array
3.  While traversing if any element smaller than min_idx is found then swap both the values.
4.  Then, increment min_idx to point to next element
5.  Repeat until array is sorted
 */

// Time & Space Complexity
/*
    Worst complexity: O(n^2)
    Average complexity: O(n^2)
    Best complexity: O(n^2)
    Space complexity: O(1)
 */

// Anuj Bhaiya - https://www.youtube.com/watch?v=B-nqY6IYqVw