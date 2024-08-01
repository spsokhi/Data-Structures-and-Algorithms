package Arrays;

import java.util.HashMap;
import java.util.Map;

public class Find_the_Number_that_Appear_Once {

    // Method 1 : Brute Force
    // Time - O(N*N), Space - O(1)
//    static int getSingleElement(int[] arr) {
//        int n = arr.length;
//
//        for (int i=0; i<n; i++) {
//            int count = 0;
//            for (int j=0; j<n; j++) {
//                if (arr[i] == arr[j]) {
//                    count++;
//                }
//            }
//            if (count == 1) {
//                return arr[i];
//            }
//        }
//        return -1;
//    }

    // Method 2 : Better Solution (Using Hashing)
    // Time - O(2N), Space - O(N)
//    static int getSingleElement(int[] arr) {
//        int n = arr.length;
//
//        int maxi = arr[0];
//        for (int i=0; i<n; i++) {
//            maxi = Math.max(maxi, arr[i]);
//        }
//
//        int[] hash = new int[maxi+1];
//        for (int i=0; i<n; i++) {
//            hash[arr[i]]++;
//        }
//
//        for (int i=0; i<n; i++) {
//            if (hash[arr[i]] == 1) {
//                return arr[i];
//            }
//        }
//        return -1;
//    }

    // Method 3 : Better Solution (Using HashMap)
    // Time Complexity: O(N*logM) + O(M), where M = size of the map i.e. M = (N/2)+1. N = size of the array.
    // Reason: We are inserting N elements in the map data structure and insertion takes logM time(where
    // M = size of the map). So this results in the first term O(N*logM). The second term is to iterate the
    // map and search the single element. In Java, HashMap generally takes O(1) time complexity for insertion
    // and search. In that case, the time complexity will be O(N) + O(M).
    // Space Complexity: O(M) as we are using a map data structure. Here M = size of the map i.e. M = (N/2)+1.
//    static int getSingleElement(int[] arr) {
//        int n = arr.length;
//
//        HashMap<Integer, Integer> map = new HashMap<>();
//
//        for (int element : arr) {
//            if (map.containsKey(element)) {
//                map.put(element, map.get(element) + 1);
//            }
//            else {
//                map.put(element, 1);
//            }
//        }
//
//        for (Map.Entry<Integer, Integer> iterator : map.entrySet()) {
//            if (iterator.getValue() == 1) {
//                return iterator.getKey();
//            }
//        }
//        return -1;
//    }

    // Method 4 : Optimal Solution (Using Xor)
    // Time - O(N), Space - O(1)
    static int getSingleElement(int[] arr) {
        int n = arr.length;

        int xor = 0;
        for (int i=0; i<n; i++) {
            xor = xor ^ arr[i];
        }
        return xor;
    }

    // Main Function
    public static void main(String args[]) {
        int[] arr = {4, 1, 2, 1, 2, 3, 3, 4, 9};
        int ans = getSingleElement(arr);
        System.out.println("The single element is: " + ans);
    }
}

// Output -
// 9

// Algorithm : Brute Force
/*
1. First, we will run a loop(say i) to select the elements of the array one by one.
2. For every element arr[i], we will perform a linear search using another loop and count its occurrence.
3. If for any element the occurrence is 1, we will return it.
 */

// Algorithm : Better Solution (Using Hashing)
/*
1. First, we will find the maximum element of the array.
2. Then, we will create a hash array of size max+1 and initialize it with 0.
3. Then, we will traverse the array and increment the count of the element in the hash array.
4. Then, we will traverse the hash array and return the element whose count is 1.
 */

// Algorithm : Better Solution (Using HashMap)
/*
1. First, we will declare a map.
2. Now, using a loop we will store the elements of the array along with their frequency in the map data structure.
3. Using another loop we will iterate over the map, and try to find the element for which the frequency is 1, and finally,
   we will return that particular element.
 */

// Algorithm : Optimal Solution (Using Xor)
/*
1. First, we will initialize a variable xor with 0.
2. Then, we will traverse the array and perform xor operation of the variable xor with the elements of the array.
3. Then, we will return the value of the variable xor.
 */

// Striver (Video Explanation) : https://youtu.be/bYWLJb3vCWY