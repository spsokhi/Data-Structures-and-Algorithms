package Sorting;

// Bubble Sort Class
public class BubbleSort {

    // Bubble Sort Method
    public void bubbleSort(int[] arr) {
        int n = arr.length;

        // Outer Loop
        for (int i = 0; i < n - 1; i++) {
            // Inner Loop for all elements (So, each time biggest element is placed on last cell)
            for (int j = 0; j < n - i - 1; j++) {
                // Checking, If next element is smaller than previous element, than swap it
                if (arr[j + 1] < arr[j]) {
                    // swap arr[j+1] and arr[j]
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    // Print Method (Print all the sorted element)
    void printArray(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    // Main Method
    public static void main(String[] args) {
        // Create an Object of Bubble Sort Class
        BubbleSort bs = new BubbleSort();
        int[] arr = {2, 8, 9, 1, 4};
        bs.bubbleSort(arr);
        bs.printArray(arr);
    }
}

// In Bubble Sort (Idea) - Push the maximum element to the last, using adjacent swaps.

// Output:
// 1 2 4 8 9

// Algorithms (Approach)
/*
1. Outer loop for index - 1 element
2. Inner loop for adjacent element
3. Comparing 2nd element to 1st element & So on...
4. Swap (if 2nd element is smaller than 1st element) & So on...
*/

// Time & Space Complexity
/*
Worst complexity: O(n^2)
Average complexity: O(n^2)
Best complexity: O(n)
Space complexity: O(1)
*/


// Anuj Bhaiya - https://www.youtube.com/watch?v=bBQkErahU9c