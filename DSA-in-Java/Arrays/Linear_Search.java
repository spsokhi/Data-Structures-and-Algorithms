package Arrays;

public class Linear_Search {

    // Method 1 - Optimal Solution
    // Time - O(N), Space - O(1)
    static int searchInSorted(int[] arr, int N, int K) {
        // Your code here
        for(int i=0; i<N; i++) {
            if (arr[i] == K) return 1;
        }
        return -1;
    }
}

// Algorithm: Optimal Solution
/*
1. Traverse the array from start to end.
2. Check if K is equal to any element in the array.
3. If yes, return 1.
4. If no, return -1.
 */

// Striver (Video Link) : https://youtu.be/wvcQg43_V8U