package Arrays;

import java.util.*;

public class Three_Sum {

    // Method 1 - Brute Force
    // Time Complexity: O(N^3), Space Complexity: O(N)
//    static List<List<Integer>> threeSum(int[] arr) {
//        int n = arr.length;
//        Set<List<Integer>> set = new HashSet<>();
//
//        for (int i = 0; i < n; i++) {
//            for (int j = i + 1; j < n; j++) {
//                for (int k = j + 1; k < n; k++) {
//                    if (arr[i] + arr[j] + arr[k] == 0) {
//                        List<Integer> temp = new ArrayList<>();
//                        temp.add(arr[i]);
//                        temp.add(arr[j]);
//                        temp.add(arr[k]);
//                        Collections.sort(temp);
//                        set.add(temp);
//                    }
//                }
//            }
//        }
//        List<List<Integer>> ans = new ArrayList<>(set);
//        return ans;
//    }

    // Method 2 - Better Solution
    // Time Complexity: O(N^2 * log m), Space Complexity: O(N) + (no. of triplets) * 2
//    static List<List<Integer>> threeSum(int[] arr) {
//        HashSet<List<Integer>> mainSet = new HashSet<>();
//
//        int n = arr.length;
//
//        for (int i = 0; i < n; i++) {
//            HashSet<Integer> hashSet = new HashSet<>();
//
//            for (int j = i + 1; j < n; j++) {
//                int third = -(arr[i] + arr[j]);
//                if (hashSet.contains(third)) {
//                    List<Integer> tempList = new ArrayList<>();
//                    tempList.add(arr[i]);
//                    tempList.add(arr[j]);
//                    tempList.add(third);
//                    Collections.sort(tempList);
//                    mainSet.add(tempList);
//                }
//                hashSet.add(arr[j]);
//            }
//        }
//        List<List<Integer>> ans = new ArrayList<>(mainSet);
//        return ans;
//    }

    // Method 3 - Optimal Solution (Using Two Pointer Approach)
    // Time : O(N^2) + O(N*logN), Space : O(3*k)  // k is the no.of triplets.
    static List<List<Integer>> threeSum(int[] arr) {
        List<List<Integer>> ans = new ArrayList<>();

        int n = arr.length;

        Arrays.sort(arr);
        for (int i=0; i<n; i++) {
            if (i>0 && arr[i] == arr[i-1]) {
                continue;
            }
            int j=i+1;
            int k=n-1;

            while (j < k) {
                int sum = arr[i] + arr[j] + arr[k];
                if (sum < 0) {
                    j++;
                }
                else if (sum > 0) {
                    k--;
                }
                else {
                    List<Integer> tempList = new ArrayList<>();
                    tempList.add(arr[i]);
                    tempList.add(arr[j]);
                    tempList.add(arr[k]);
                    ans.add(tempList);
                    j++;
                    k--;
                    while (j < k && arr[j] == arr[j-1]) {
                        j++;
                    }
                    while (j < k && arr[k] == arr[k+1]) {
                        k--;
                    }
                }
            }
        }
        return ans;
    }

    // Main Function
    public static void main(String[] args) {
        int[] arr = {-1, 0, 1, 2, -1, -4}; // Output: [[-1,-1,2],[-1,0,1]]
        System.out.println(threeSum(arr));
    }
}

// Output: [[-1,-1,2],[-1,0,1]]

// Algorithm : Brute Force
/*
1. Create an empty list ans which stores the answer
2. Run a loop from i=0 to n-2
    2.1 Run a loop from j=i+1 to n-1
        2.1.1 Run a loop from k=j+1 to n
3. If arr[i] + arr[j] + arr[k] == 0, then add arr[i], arr[j], arr[k] to ans
4. Return ans
 */

// Algorithm : Better Solution
/*
1. Create an empty list ans which stores the answer
2. Run a loop from i=0 to n-1
    2.1 Create a hashset hashSet
    2.2 Run a loop from j=i+1 to n-1
        2.2.1 third = -(arr[i] + arr[j])
        2.2.2 If hashSet contains third, then add arr[i], arr[j], third to ans
        2.2.3 Add arr[j] to hashSet
3. Return ans
 */

// Algorithm : Optimal Solution (Using Two Pointer Approach)
/*
1. Create an empty list ans which stores the answer
2. Sort the array
3. Run a loop from i=0 to n-1
    Checks :
    3.1 If i>0 and arr[i] == arr[i-1], then continue
    3.2 j=i+1, k=n-1
    3.3 While j < k
        3.3.1 sum = arr[i] + arr[j] + arr[k]
        3.3.2 If sum < 0, then j++
        3.3.3 Else if sum > 0, then k--
        3.3.4 Else
4. Check if j > i+1 and arr[j] == arr[j-1], then j++
5. Check if k < n-1 and arr[k] == arr[k+1], then k--
6. Return ans
 */

// Striver (Video Explanation) : https://youtu.be/DhFh8Kw7ymk