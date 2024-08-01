package Arrays;

public class Right_Rotate_an_Array_by_K_Place {

    // Method 1 - Brute Force (Using Temporary Array)
    // Time - O(N), Space - O(K) (K is the number of elements to be rotated)
//    static void rotateRight(int[] arr, int k, int n) {
//        if (n == 0) return;
//        k = k % n;
//
//        int[] temp = new int[k];
//        for (int i=n-k; i<n; i++) {
//            temp[i - n + k] = arr[i];
//        }
//
//        for (int i=n-k-1; i>=0; i--) {
//            arr[i + k] = arr[i];
//        }
//
//        for (int i=0; i<k; i++) {
//            arr[i] = temp[i];
//        }
//    }

    // Method 2 - (Using Reverse Algorithm)
    // Time - O(N), Space - O(1)
    static void rotateRight(int[] arr, int k, int n) {
        // Reverse first n-k elements
        reverse(arr, 0, n - k - 1);
        // Reverse last k elements
        reverse(arr, n-k, n-1);
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
        int k = 4;
        rotateRight(arr, k, n);
        System.out.println("After Rotating the elements to right ");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}

// Output -
/*
After Rotating the elements to left
6 7 1 2 3 4 5
 */

// Algorithm: Brute Force (Using Temporary Array)
/*
1. Create a temporary array of size k and store the last k elements of the given array in it.
2. Shift n-k elements from the beginning by k position to the right.
3. Copy the elements into the main array from the temp array.
4. Return the array.
 */

// Algorithm: Optimal Solution (Using Reverse Algorithm)
/*
1. Reverse the last k elements of the array.
2. Reverse the first n-k elements of the array.
3. Reverse the whole array.
 */

// Striver (Video Link) : https://youtu.be/wvcQg43_V8U