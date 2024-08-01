package Sorting;

// Merge Sort Class
public class MergeSort {

    // Main Merge Sort Function
    public static void conquer(int[] arr, int startIndex, int mid, int endIndex) {
        // Create an empty merged (temp) array (size of array)
        int merged[] = new int[endIndex - startIndex + 1];

        // Then adding the elements on merged array
        // index1 track 1st subArray
        int index1 = startIndex;
        // index2 track 2nd subArray
        int index2 = mid + 1;
        // Track merge indexes
        int x = 0;

        // This while loop will run until comparing all the two array (index1 & index2)
        // If index1 is smaller than mid & index2 is smaller then endIndex
        while (index1 <= mid && index2 <= endIndex) {
            // 1st array is smaller than 2nd array
            if (arr[index1] <= arr[index2]) {
                // adding index1 in merged array (temp)
                merged[x] = arr[index1];
                x++;
                index1++;
            } else {
                // 1st array is greater than 2nd array
                // adding index2 in merged array (temp)
                merged[x] = arr[index2];
                x++;
                index2++;
            }
        }

        // If we complete all elements of 1st subArray, but some element of 2nd subArray is remaining
        while (index1 <= mid) {
            merged[x] = arr[index1];
            x++;
            index1++;
        }

        // If we complete all elements of 2nd subArray, but some element of 1st subArray is remaining
        while (index2 <= endIndex) {
            merged[x] = arr[index2];
            x++;
            index2++;
        }

        // To copy the Element of Merge inside the original array
        for (int i = 0, j = startIndex; i < merged.length; i++, j++) {
            arr[j] = merged[i];
        }
    }

    // Merge Sort Function
    public static void mergeSort(int[] arr, int startIndex, int endIndex) {
        // If at a point starting index is greater than & equal to ending index,
        // then know, we have a single element or know, destroy an array
        if (startIndex >= endIndex) {
            return;
        }
        // First we find middle index
        int mid = startIndex + (endIndex - startIndex) / 2;
        // Left subArray ( Recursive Call )
        mergeSort(arr, startIndex, mid);
        // Right subArray ( Recursive Call )
        mergeSort(arr, mid + 1, endIndex);

        // Call conquer function
        conquer(arr, startIndex, mid, endIndex);
    }

    // Main Function
    public static void main(String[] args) {
        int[] arr = {6, 3, 9, 5, 2, 8};
        int n = arr.length;
        mergeSort(arr, 0, n - 1);

        // Print array function
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}

// Merge sort is defined as a sorting algorithm that works by dividing an array into smaller
// subarrays, sorting each subarray, and then merging the sorted subarrays back together to
// form the final sorted array.

// Algorithm (approach) -
/*
1. Start
2. Declare array and start, end, mid variable
3. Perform merge function.
        mergesort(array,start,end)
        mergesort (array, start, end)
        if start > end
        return
        mid= (start+end)/2
        mergesort(array, start, mid)
        mergesort(array, mid+1, end)
        merge(array, left, mid, right)
4. Stop
 */

// Time & Space Complexity
/*
    Worst complexity: O[n*log(n)]
    Average complexity: O[n*log(n)]
    Best complexity: O[n*log(n)]
    Space complexity: O(n)
 */

// Apna College (Video Explanation) - https://www.youtube.com/watch?v=unxAnJBy12Q