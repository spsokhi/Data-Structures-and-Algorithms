package Arrays;

public class Max_Consecutive_Ones {

    // Method 1 - Brute Force (Using Temporary Array)
    // Time - O(2N), Space - O(N)
//    static int max(int[] arr, int n) {
//        int[] temp = new int[n];
//
//        for (int i=0; i<n; i++) {
//            temp[i] = arr[i];
//        }
//
//        int tempSize = temp.length;
//        int count = 0;
//
//        for (int i=0; i<tempSize; i++) {
//            if (temp[i] == 1) {
//                count++;
//            } else if (temp[i] == 0) {
//                count = 0;
//            }
//        }
//        return count;
//    }

    // Method 2 - Optimal Solution (Using 2 Pointers)
    // Time - O(N), Space - O(1)
    public int max(int[] arr, int n) {
        int count = 0;
        int max = 0;

        for (int i=0; i<n; i++) {
            if (arr[i] == 1) {
                count++;
                if (count > max) {
                    max = count;
                }
            }
            else {
                count = 0;
            }
        }
        return max;
    }

    // Main Function
    public static void main(String[] args) {
        int[] arr = {1, 1, 0, 1, 1, 1};
        int n = arr.length;

        Max_Consecutive_Ones obj = new Max_Consecutive_Ones();
        int result = obj.max(arr, n);
        System.out.println(result);
    }
}

// Output:
// 3

// Algorithm: Brute Force (Using Temporary Array)
/*
1. Create a temporary array of size n.
2. Copy all the elements of the original array into the temporary array.
3. Traverse the temporary array and count the number of consecutive 1s.
4. If the count is greater than the max, then update the max.
5. Return the max.
 */

// Algorithm: Optimal Solution (Using 2 Pointers)
/*
1. Initialize count and max to 0.
2. Traverse the array.
3. If the element is 1, then increment the count.
4. If the count is greater than the max, then update the max.
5. If the element is 0, then reset the count to 0.
6. Return the max.
 */

// Striver - (Video Link) https://youtu.be/bYWLJb3vCWY