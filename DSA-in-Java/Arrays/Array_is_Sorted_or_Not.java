package Arrays;

public class Array_is_Sorted_or_Not {

    // Method 1 - Brute Force (Using Two For Loops)
    // Time - O(N^2), Space - O(1)
//    static int sorted(int[] arr, int n) {
//        for(int i=0; i<n; i++) {
//            for (int j=i+1; j<n; j++) {
//                if (arr[j] < arr[i]) {
//                    return 0;
//                }
//            }
//        }
//        return 1;
//    }

    // Method 2 - Optimal Solution (Using Single Traversal)
    // Time - O(N), Space - O(1)
    static int sorted(int[] arr, int n) {
        for (int i=1; i<n-1; i++) {
            if (arr[i] < arr[i-1]) {
                return 0;
            }
        }
        return 1;
    }

    // Main Function
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 5, 4};
        int n = arr.length;
        int result = sorted(arr, n);
        if (result == 1) {
            System.out.println("Array is sorted");
        }
        else {
            System.out.println("Array is not sorted");
        }
    }
}

// Output: Array is not sorted

// Algorithm: Brute Force (Using Two For Loops)
/*
1. The idea is pretty simple here, We will start with the element at the 0th index, and will compare it
   with all of its future elements that are present in the array.
2. If the picked element is smaller than or equal to all of its future values then we will move to the next
   Index/element until the whole array is traversed.
3. If any of the picked elements is greater than its future elements, Then simply we will return False.
4. If the size of the array is Zero or One i.e ( N = 0 or N = 1 ) or the entire array is traversed successfully then
   we will simply return True.
 */

// Algorithm: Optimal Solution (Using Single Traversal)
/*
1. As we know that for a sorted array the previous of every element is smaller than or equal to its
   current element.
2. So, Through this, we can conclude that if the previous element is smaller than or equal to the
   current element then. Then we can say that the two elements are sorted. If the condition is true for
   the entire array then the array is sorted.
3. We will check every element with its previous element if the previous element is smaller than or
   equal to the current element then we will move to the next index.
4. If the whole array is traversed successfully or the size of the given array is zero or one
   (i.e N = 0 or N = 1). Then we will return True else return False.
 */

// Striver Video Link : https://youtu.be/37E9ckMDdTk