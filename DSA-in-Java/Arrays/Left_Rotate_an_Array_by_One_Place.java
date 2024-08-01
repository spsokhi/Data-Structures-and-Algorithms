package Arrays;

public class Left_Rotate_an_Array_by_One_Place {

    // Method 1 - Brute Force
    // Time - O(N), Space - O(N)
//     static void leftRotate(int[] arr, int n) {
//         int temp[]=new int[n];
//         for (int i = 1; i < n; i++) {
//             temp[i - 1] = arr[i];
//         }
//         temp[n - 1] = arr[0];
//         for (int i = 0; i < n; i++) {
//             System.out.print(temp[i]+" ");
//         }
//     }

    // Method 2 - Optimal Solution (Using temp variable)
    // Time - O(N), Space - O(1)
    static void leftRotate(int[] arr, int n) {
        int temp = arr[0];
        for (int i=0; i<n-1; i++) {
            arr[i] = arr[i+1];
        }
        arr[n-1] = temp;
        for (int i=0; i< n; i++) {
            System.out.printf(arr[i] + " ");
        }
    }

    // Main Function
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7};
        int n = arr.length;
        leftRotate(arr, n);
    }
}

// Algorithm: Brute Force
/*
1. Create a temporary array of size n.
2. Store the first element of the array in a temporary variable.
3. Shift rest of the elements of the array one by one.
4. Store the value of the temporary variable at the last index of the array.
5. Print the array.
 */

// Algorithm: Optimal Solution
/*
1. Store the first element of the array in a temporary variable.
2. Shift rest of the elements of the array one by one.
3. Store the value of the temporary variable at the last index of the array.
4. Print the array.
 */

// Striver (Video Link) : https://youtu.be/wvcQg43_V8U