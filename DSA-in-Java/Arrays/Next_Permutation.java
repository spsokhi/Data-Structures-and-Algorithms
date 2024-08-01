package Arrays;

public class Next_Permutation {

    // Swap Function
    static void swap (int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // Reverse Function
    static void reverse (int[] arr, int i, int j) {
        while (i < j) {
            swap(arr, i, j);
            i++;
            j--;
        }
    }

    // Method 1 - Optimal Solution (Using some observations)
    // Time - O(3N), where N = size of the given array
    //Finding the break-point, finding the next greater element, and reversal at the end takes O(N) for each,
    // where N is the number of elements in the input array. This sums up to 3*O(N) which is approximately O(3N). ,
    //Space Complexity: Since no extra storage is required. Thus, its space complexity is O(1).
    public static void nextPermutation (int[] arr, int n) {
        // Find longest prefix match (means find the dip)
        // case : {2, 1, | 5, 4, 3, 0, 0} ('|' stands for dip)
        int idx = -1;
        for (int i=n-2; i>=0; i--) {
            if (arr[i] < arr[i+1]) {
                idx = i;
                break;
            }
        }

        // If the idx variable is not updated means the array is in descending order
        // So, we reverse the array - case : {5, 4, 3, 2, 1}
        if (idx == -1) {
            reverse(arr, 0, n-1);
            return;
        }

        // Find the greater value which is just greater than the value at idx
        // case : {2, 1, | 5, 4, 3, 0, 0}
        // In this case 3 is just greater than 1
        for (int i=n-1; i>idx; i--) {
            if (arr[i] > arr[idx]) {
                swap(arr, i, idx);
                break;
            }
        }

        // Sort the arr in ascending order from idx+1 to n-1
        // so the next permutation is the smallest possible permutation
        reverse(arr, idx+1, n-1);
    }

    // Main Function
    public static void main(String[] args) {
        int[] arr = {2, 1, 5, 4, 3, 0, 0};
        int n = arr.length;

        nextPermutation(arr, n);

        for (int i=0; i<n; i++)
            System.out.print(arr[i] + " ");
    }
}

// Output:
// 2 3 0 0 1 4 5

// Algorithm: Optimal Solution (Using some observations)
/*
1. Find the longest prefix match (means find the dip)
2. If the idx variable is not updated means the array is in descending order. So, we reverse the array
3. Find the greater value which is just greater than the value at idx
4. Sort the arr in ascending order from idx+1 to n-1, so the next permutation is the smallest possible permutation
 */

// Algorithm + Intuition:
/*
1. Find the break-point, i: Break-point means the first index i from the back of the given array
where arr[i] becomes smaller than arr[i+1].

For example, if the given array is {2,1,5,4,3,0,0}, the break-point will be index 1(0-based indexing).
Here from the back of the array, index 1 is the first index where arr[1] i.e. 1 is smaller than arr[i+1] i.e. 5
.
To find the break-point, using a loop we will traverse the array backward and store the index i where arr[i]
is less than the value at index (i+1) i.e. arr[i+1].

2. If such a break-point does not exist i.e. if the array is sorted in decreasing order, the given permutation is the
last one in the sorted order of all possible permutations. So, the next permutation must be the first i.e.
the permutation in increasing order.

So, in this case, we will reverse the whole array and will return it as our answer.

3. If a break-point exists:
    1. Find the smallest number i.e. > arr[i] and in the right half of index i(i.e. from index i+1 to n-1) and swap it with arr[i].
    2. Reverse the entire right half(i.e. from index i+1 to n-1) of index i. And finally, return the array.
 */

// Algorithm: Brute Force
/*
Algorithm / Intuition
Brute Force: Finding all possible permutations.

Approach :

Step 1: Find all possible permutations of elements present and store them.

Step 2: Search input from all possible permutations.

Step 3: Print the next permutation present right after it.

For reference of how to find all possible permutations, follow up https://www.youtube.com/watch?v=f2ic2Rsc9pU&t=32s.
This video shows for distinct elements but code works for duplicates too.

Time - For finding, all possible permutations, it is taking N!xN. N represents the number of elements present
in the input array. Also for searching input arrays from all possible permutations will take N!. Therefore,
it has a Time complexity of O(N!xN).

Space - Since we are not using any extra spaces except stack spaces for recursion calls. So,
it has a space complexity of O(1).
 */

// Striver - https://youtu.be/JDOXKqF60RQ