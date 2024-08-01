package Arrays;

import java.util.ArrayList;

public class Rearrange_Array_Elements_by_Sign {

    // Varient 1 - There’s an array ‘arr’ of size ‘n’ with positive and negative elements (are equal)
    // Method 1 - Brute Force (Using Extra Space)
    // Time - O(N+N/2) { O(N) for traversing the array once for segregating positives and negatives and another O(N/2)
    // for adding those elements alternatively to the array, where N = size of the array A}.
    // Space - O(N/2 + N/2) = O(N) { N/2 space required for each of the positive and negative element arrays,
    // where N = size of the array A}.
//    static int[] rearrange (int[] arr, int n) {
//        ArrayList<Integer> pos = new ArrayList<>();
//        ArrayList<Integer> neg = new ArrayList<>();
//
//        for (int i=0; i<n; i++){
//            if (arr[i] >= 0)
//                pos.add(arr[i]);
//            else
//                neg.add(arr[i]);
//        }
//
//        for (int i=0; i<n/2; i++) {
//            arr[2 * i] = pos.get(i);
//            arr[2 * i + 1] = neg.get(i);
//        }
//        return arr;
//    }

    // Method 2 - Optimal Solution (Using Extra Space)
    // Time - O(N) { O(N) for traversing the array once and substituting positives and negatives simultaneously using pointers,
    // where N = size of the array A}.
    // Space - O(N) { Extra Space used to store the rearranged elements separately in an array, where N = size of array A}.
//    static int[] rearrange (int[] arr, int n) {
//        int pos = 0, neg = 1;
//        int[] temp = new int[n];
//
//        for (int i=0; i<n; i++) {
//            if (arr[i] > 0) {
//                temp[pos] = arr[i];
//                pos += 2;
//            }
//            else {
//                temp[neg] = arr[i];
//                neg += 2;
//            }
//        }
//        return temp;
//    }

    // Varient 2 - There’s an array ‘A’ of size ‘N’ with positive and negative elements (not necessarily equal)
    // Method 1 - Brute Force (Using Extra Space)
    // Time - O(2*N) { The worst case complexity is O(2*N) which is a combination of O(N) of traversing the array to
    // segregate into neg and pos array and O(N) for adding the elements alternatively to the main array}.
    // Space - O(N/2 + N/2) = O(N) { N/2 space required for each of the positive and negative element arrays, where N = size of the array A}.
    static int[] rearrange (int[] arr, int n) {
        ArrayList<Integer> pos = new ArrayList<>();
        ArrayList<Integer> neg = new ArrayList<>();

        for (int i=0; i<n; i++) {
            if (arr[i] >= 0)
                pos.add(arr[i]);
            else
                neg.add(arr[i]);
        }

        if (pos.size() > neg.size()) {
            for (int i=0; i<neg.size(); i++) {
                arr[2*i] = pos.get(i);
                arr[2*i+1] = neg.get(i);
            }
            int index = neg.size() * 2;
            for (int i= neg.size(); i<pos.size(); i++) {
                arr[index] = pos.get(i);
                index++;
            }
        }
        else {
            for (int i=0; i<pos.size(); i++) {
                arr[2*i] = pos.get(i);
                arr[2*i+1] = neg.get(i);
            }
            int index = pos.size() * 2;
            for (int i= pos.size(); i<neg.size(); i++) {
                arr[index] = neg.get(i);
                index++;
            }
        }
        return arr;
    }

    // Main Function
    public static void main(String[] args) {
        int[] arr = {1, 2, -5, -4, -1, 4};
        int n = arr.length;

        arr = rearrange(arr, n);

        for (int i=0; i<n; i++)
            System.out.print(arr[i] + " ");
    }
}

// Output:
// 1 -5 2 -4 4 -1

// Algorithm: Brute Force (Using Extra Space) Varient 1
/*
1. Create two empty arrays pos[] and neg[] to store positive and negative elements respectively.
2. Traverse the array A[] and store all positive elements in array pos[] and all negative elements in array neg[].
3. Start a loop from index 0 to n/2 and one by one insert elements from pos[] and neg[] at index 2*i and 2*i+1 respectively.
4. Finally return the array.
 */

// Algorithm: Optimal Solution (Using Extra Space) Varient 1
/*
1. Initialize two variables pos = 0 and neg = 1 to store the next positive and negative element positions.
2. Start a loop from index 0 to n and one by one check if the element is positive or negative.
3. If the element is positive, store it at pos and increment pos by 2.
4. If the element is negative, store it at neg and increment neg by 2.
5. Finally return the array.
 */

// Algorithm: Brute Force (Using Extra Space) Varient 2
/*
1. Create two empty arrays pos[] and neg[] to store positive and negative elements respectively.
2. Traverse the array arr[] and store all positive elements in array pos[] and all negative elements in array neg[].
3. If the size of pos[] is greater than neg[], then start a loop from index 0 to neg.size() and one by one insert elements
from pos[] and neg[] at index 2*i and 2*i+1 respectively.
4. Then start another loop from index neg.size() to pos.size() and insert elements from pos[] at index pos.size() + i.
5. If the size of neg[] is greater than pos[], then start a loop from index 0 to pos.size() and one by one insert elements
from pos[] and neg[] at index 2*i and 2*i+1 respectively.
6. Then start another loop from index pos.size() to neg.size() and insert elements from neg[] at index neg.size() + i.
7. Finally return the array.
 */

// Striver - (Video Link) https://youtu.be/h4aBagy4Uok