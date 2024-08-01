package Arrays;

public class Left_Rotate_an_Array_by_K_Place {

    // Method 1 - Brute Force (Using Temporary Array)
    // Time - O(N), Space - O(K) (K is the number of elements to be rotated)
//    static void rotateLeft(int[] arr, int k, int n) {
//        if (n == 0) return;
//
//        k = k % n;
//
//        int[] temp = new int[k];
//
//        for (int i=0; i<k; i++) {
//            temp[i] = arr[i];
//        }
//
//        for (int i=k; i<n; i++) {
//            arr[i-k] = arr[i];
//        }
//
//        int j=0;
//        for (int i=n-k; i<n; i++) {
//            arr[i] = temp[j];
//            j++;
//        }
//    }

    // Method - 2 Optimal Solution (Using Reverse Algorithm)
    // Time - O(N), Space - O(1)
    static void rotateLeft(int[] arr, int k, int n) {
        // Reverse first k elements
        reverse(arr, 0, k-1);
        // Reverse last n-k elements
        reverse(arr, k, n-1);
        // Reverse whole array
        reverse(arr, 0, n-1);
    }

    // Reverse Array Function
    static void reverse(int[] arr, int low, int high) {
        while (low <= high) {
            int temp = arr[low];
            arr[low] = arr[high];
            arr[high] = temp;
            low++;
            high--;
        }
    }

    // Main Function
    public static void main(String[] args) {
        int n = 7;
        int[] arr = {1,2,3,4,5,6,7};
        int k = 2;
        rotateLeft(arr, k, n);
        System.out.println("After Rotating the elements to left ");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}

// Output -
/*
After Rotating the elements to left
3 4 5 6 7 1 2
 */

// Algorithm: Brute Force (Using Temporary Array)
/*
1. Copy the first k elements into the temp array.
2. Shift n-k elements from last by k position to the left
3. Copy the elements into the main array from the temp array.
 */

// Algorithm: Optimal Solution (Using Reverse Algorithm)
/*
1. Reverse first k elements
2. Reverse last n-k elements
3. Reverse whole array
 */

// Striver (Video Link) : https://youtu.be/wvcQg43_V8U