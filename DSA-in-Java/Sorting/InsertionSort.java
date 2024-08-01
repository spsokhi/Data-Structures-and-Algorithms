package Sorting;

// Insertion Sort Class
public class InsertionSort {

    // Insertion Sort Method
    public void insertionSort(int[] arr) {
        for (int i=1; i<arr.length; i++) {
            int temp = arr[i];
            int j = i-1;

            // Move elements of arr[0..i-1], that are
            // greater than key, to one position ahead
            // of their current position
            while (arr[j] > temp && j >= 0) {
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = temp;
        }
    }

    // Print array function
    static void printArray(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    // Main Method
    public static void main(String[] args) {
        InsertionSort is = new InsertionSort();
        // Create an object of Insertion Sort Class
        int[] arr = {1,9,4,6,8};
        is.insertionSort(arr);
        printArray(arr);
    }
}

// In Insertion Sort (Idea) - Take an element from unsorted array and insert it at its correct position
// in sorted array.

// Output
/*
1 4 6 8 9
 */

// Algorithms (approach)
/*
 To sort an array of size N in ascending order:

1. Iterate from arr[1] to arr[N] over the array.
2. Compare the current element (key) to its predecessor.
3. If the key element is smaller than its predecessor,
   compare it to the elements before. Move the greater
   elements one position up to make space for the swapped element.
 */

// TIme & Space Complexity
/*
    Worst complexity: O(n^2)
    Average complexity: O(n^2)
    Best complexity: O(n)
    Space complexity: O(1)
 */

// Anuj Bhaiya - https://www.youtube.com/watch?v=wWhAhp6PIuQ