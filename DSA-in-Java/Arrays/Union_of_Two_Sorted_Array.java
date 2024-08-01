package Arrays;

import java.util.ArrayList;
import java.util.HashSet;

public class Union_of_Two_Sorted_Array {

    // Method 1 - Brute Force (Using Set)
    /*
     Time - O( (m+n)log(m+n) ) . Inserting an element in a set takes logN time, where N is no of elements in the
     set. At max set can store m+n elements {when there are no common elements and elements in arr,arr2
     are distinct}. So Inserting m+n th element takes log(m+n) time. Upon approximation across inserting
     all elements in worst, it would take O((m+n)log(m+n) time.
    */
    /*
    Space - O(m+n) {If Space of Union ArrayList is considered}
    O(1) {If Space of union ArrayList is not considered}
    */
//    public static ArrayList<Integer> findUnion(int[] arr1, int[] arr2, int n, int m)
//    {
//        HashSet<Integer> set = new HashSet<>();
//
//        ArrayList<Integer> list = new ArrayList<>();
//
//        for (int i=0; i<n; i++) {
//            set.add(arr1[i]);
//        }
//
//        for (int i=0; i<m; i++) {
//            set.add(arr2[i]);
//        }
//
//        for (int elements : set) {
//            list.add(elements);
//        }
//        return list;
//    }

    // Method 2 - Optimal Solution (Using 2 Pointers)
    /*
    Time - O(m+n), Because at max i runs for n times and j runs for m times. When there are no common
    elements in arr1 and arr2 and all elements in arr1, arr2 are distinct.
     */
    /*
    Space - O(m+n) {If Space of Union ArrayList is considered}
    O(1) {If Space of union ArrayList is not considered}
     */
    public static ArrayList<Integer> findUnion(int[] arr1, int[] arr2, int n, int m)
    {
        // Create a list
        ArrayList<Integer> list = new ArrayList<>();

        // pointers
        int i = 0;
        int j = 0;

        while (i < n && j < m) {
            if (arr1[i] <= arr2[j]) {
                if (list.size() == 0 || list.get(list.size()-1) != arr1[i]) {   // Case 1 and 2
                    list.add(arr1[i]);
                }
                i++;
            }
            else {
                if (list.size() == 0 || list.get(list.size()-1) != arr2[j]) {   // Case 3
                    list.add(arr2[j]);
                }
                j++;
            }
        }

        while (i < n) {     // If any element left in arr1
            if (list.get(list.size()-1) != arr1[i]) {
                list.add(arr1[i]);
            }
            i++;
        }

        while (j < m) {     // If any element left in arr2
            if (list.get(list.size()-1) != arr2[j]) {
                list.add(arr2[j]);
            }
            j++;
        }
        return list;
    }

    // Main Function
    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 4, 5};
        int n = arr1.length;
        int[] arr2 = {1, 2, 3};
        int m = arr2.length;
        ArrayList<Integer> list = findUnion(arr1, arr2, n, m);
        System.out.println(list);
    }
}

// Algorithm: Brute Force (Using Set)
/*
1. Create a set.
2. Insert all the elements of arr1 in the set.
3. Insert all the elements of arr2 in the set.
4. Insert all the elements of set in the list.
5. Return the list.
 */

// Algorithm: Optimal Solution (Using Two Pointers)
/*
1. Create a list.
2. Create two pointers i and j.
3. Run a loop till i < n and j < m.
4. If arr1[i] <= arr2[j], then check if list is empty or last element of list is not equal to arr1[i], then add
arr1[i] in the list. Increment i.
5. Else, check if list is empty or last element of list is not equal to arr2[j], then add arr2[j] in the list.
Increment j.
6. Run a loop till i < n and add all the elements of arr1 in the list.
7. Run a loop till j < m and add all the elements of arr2 in the list.
8. Return the list.
 */

// Striver (Video Link) : https://youtu.be/wvcQg43_V8U