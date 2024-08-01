package Arrays;

import java.util.ArrayList;
import java.util.Arrays;

public class Intersection_of_Two_Sorted_Array {

    // Method 1 - Brute Force (Using Temporary Array)
    // Time - O(N*M), Space - O(M)
//    public static ArrayList<Integer> findIntersection(int[] arr1, int[] arr2, int n, int m)
//    {
//        ArrayList<Integer> list = new ArrayList<>();
//
//        int[] visited = new int[m];
//
//        Arrays.fill(visited, 0);
//
//        for (int i=0; i<n; i++) {
//            for (int j=0; j<m; j++) {
//                if (arr1[i] == arr2[j] && visited[j] == 0) {
//                    list.add(arr1[i]);
//                    visited[j] = 1;
//                    break;
//                }
//                if (arr1[i] < arr2[j]) break;
//            }
//        }
//        return list;
//    }

    // Method 2 - Optimal Solution (Using 2 Pointers)
    // Time - O(N+M), Space - O(1)
    public static ArrayList<Integer> findIntersection(int[] arr1, int[] arr2, int n, int m) {
        ArrayList<Integer> list = new ArrayList<>();

        int i = 0;
        int j = 0;

        while (i < n && j < m) {
            if (arr1[i] < arr2[j]) {
                i++;
            }
            else if (arr1[i] > arr2[j]) {
                j++;
            }
            else {
                list.add(arr1[i]);
                i++;
                j++;
            }
        }
        return list;
    }

    // Main Function
    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 4, 5};
        int n = arr1.length;
        int[] arr2 = {1, 2, 3};
        int m = arr2.length;

        ArrayList<Integer> intersection = findIntersection(arr1, arr2, n, m);

        System.out.print("Intersection of the two arrays: ");
        for (int num : intersection) {
            System.out.print(num + " ");
        }
    }
}

// Output -
/*
Intersection of the two arrays: 1 2 3
 */

// Algorithm: Brute Force (Using Temporary Array)
/*
1. Create a list.
2. Create a temporary array of size m.
3. Initialize all the elements of temporary array with 0.
4. Traverse the arr1.
5. Traverse the arr2.
6. If arr1[i] == arr2[j] and visited[j] == 0, then add arr1[i] in the list and mark visited[j] = 1.
7. If arr1[i] < arr2[j], then break the loop.
8. Return the list.
 */

// Algorithm: Optimal Solution (Using 2 Pointers)
/*
1. Create a list.
2. Create two pointers i and j.
3. Traverse the arr1 and arr2.
4. If arr1[i] < arr2[j], then increment i.
5. If arr1[i] > arr2[j], then increment j.
6. If arr1[i] == arr2[j], then add arr1[i] in the list and increment i and j.
7. Return the list.
 */

// Striver (Video Link) : https://youtu.be/wvcQg43_V8U