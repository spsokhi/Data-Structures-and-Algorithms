package Searching;

public class LinearSearch {

    // Linear Search Function
    public static int search(int[] arr, int N, int x)
    {
        for (int i = 0; i < N; i++) {
            if (arr[i] == x)
                return i;
        }
        return -1;
    }

    // Main Function
    public static void main(String[] args)
    {
        int[] arr = { 2, 3, 4, 10, 40 };
        int x = 10;

        // Function call
        int result = search(arr, arr.length, x);
        if (result == -1)
            System.out.print(
                    "Element is not present in array");
        else
            System.out.print("Element is present at index "
                    + result);
    }
}

// Output
// Element is present at index 3

/*
How Does Linear Search Algorithm Work?
In Linear Search Algorithm,

1. Every element is considered as a potential match for the key and checked for the same.
2. If any element is found equal to the key, the search is successful and the index
   of that element is returned.
3. If no element is found equal to the key, the search yields “No match found”.
 */

// Time & Space Complexity
/*
Time Complexity:

1. Best Case: In the best case, the key might be present at the first index.
   So the best case complexity is O(1)

2. Worst Case: In the worst case, the key might be present at the last index i.e.,
   opposite to the end from which the search has started in the list. So the worst-case
   complexity is O(N) where N is the size of the list.

3. Average Case: O(N)

Space Complexity:

1. Auxiliary Space: O(1) as except for the variable to iterate through the list,
   no other variable is used.
 */