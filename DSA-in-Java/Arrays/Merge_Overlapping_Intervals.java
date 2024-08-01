package Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Merge_Overlapping_Intervals {

    // Method 1 : Brute Force
    // Time Complexity: O(NlogN) + O(2N) = O(NlogN)
    // Space Complexity: O(N)
    static List<List<Integer>> mergeIntervals(int[][] arr) {
        int n = arr.length;

        // sort the array by start time
        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return a[0] - b[0]; // sort by start time
            }
        });

        List<List<Integer>> ans = new ArrayList<>();

        for (int i=0; i<n; i++) {
            // pointer to start and end of current interval
            int start = arr[i][0];
            int end = arr[i][1];

            // if answer list is not empty and end time of last interval is greater
            // than or equal to start time of current interval, then skip this interval
            if (!ans.isEmpty() && end <= ans.get(ans.size()-1).get(1)) {
                continue;
            }

            // if next interval overlaps with current interval, then update end time
            for (int j=i+1; j<n; j++) {
                // means overlap
                if (arr[j][0] <= end) {
                    end = Math.max(end, arr[j][1]);
                } else { // means no overlap
                    break;
                }
            }

            // add current interval to answer list
            ans.add(Arrays.asList(start, end));
        }
        return ans;
    }
    // Method 2 : Optimal Solution
    // Time Complexity: O(NlogN) + O(N) = O(NlogN)
    // Space Complexity: O(N)
    static List<List<Integer>> mergeIntervals1(int[][] arr) {
        int n = arr.length;

        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return a[0] - b[0];
            }
        });

        List<List<Integer>> ans = new ArrayList<>();

        for (int i=0; i<n; i++) {
            // this case means there is no overlapping between the intervals
            // means, a new interval is added or new interval is formed (so we can added a new interval)
            if (ans.isEmpty() || arr[i][0] > ans.get(ans.size()-1).get(1)) {
                ans.add(Arrays.asList(arr[i][0], arr[i][1]));
            }
            // this case means overlapping
            // so, we can simply check the last element of previous element, or (start, end) of current interval
            else {
                ans.get(ans.size()-1).set(1, Math.max(ans.get(ans.size()-1).get(1), arr[i][1]));
            }
        }
        return ans;
    }

    // Main Function
    public static void main(String[] args) {
        int[][] arr = {{1,3}, {2,6}, {8,10}, {15,18}};
        List<List<Integer>> ans = mergeIntervals1(arr);
        System.out.println(ans);
    }
}

// Output: [[1, 6], [8, 10], [15, 18]]

// Algorithm : Brute Force
/*
1. First, we will group the closer intervals by sorting the given array of intervals(if it is not already sorted).
2. After that, we will select one interval at a time using a loop(say i) and insert it into our answer list
(if the answer list is empty or the current interval cannot be merged with the last interval of the answer list).
While traversing and inserting we will skip the intervals that lie in the last inserted interval of our answer list.
3. Now, for each interval arr[i], using another loop (say j) we are going to check the rest of the intervals
(i.e. From index i+1 to n-1) if they can be merged with the selected interval.
4. Inside loop j, we will continue to merge all the intervals that lie in the selected interval.
    1. How to check if the current interval can be merged with the selected interval:
       We will compare the current interval’s start with the end of the selected interval. If the start is
       smaller or equal to the end, we can conclude the current interval can be a part of the selected interval.
       So, we will update the selected interval’s end with the maximum(current interval’s end, selected interval’s
       end) in the answer list(not in the original array).
5. We will break out of loop j, from the first element that cannot be a part of the selected interval.
    1. How to check if the current interval is not a part of the selected interval:
       We will compare the current interval’s start with the end of the selected interval. If the start is
       greater than the end, we can conclude the current interval cannot be a part of the selected interval.
6. Finally, we will return the answer list.
 */

// Time & Space Complexity : Brute Force
/*
Time Complexity: O(N*logN) + O(2*N), where N = the size of the given array.
Reason: Sorting the given array takes  O(N*logN) time complexity. Now, after that, we are using 2 loops i and j.
But while using loop i, we skip all the intervals that are merged with loop j. So, we can conclude that every
interval is roughly visited twice(roughly, once for checking or skipping and once for merging). So, the time
complexity will be 2*N instead of N2.

Space Complexity: O(N), as we are using an answer list to store the merged intervals. Except for the answer array,
we are not using any extra space.
 */

// Algorithm : Optimal Solution
/*
1. First, we will group the closer intervals by sorting the given array of intervals(if it is not already sorted).
2. After that, we will start traversing the array using a loop(say i) and insert the first element into our answer
 list(as the answer list is empty).
3. Now, while traversing we will face two different cases:
    Case 1: If the current interval can be merged with the last inserted interval of the answer list:
    In this case, we will update the end of the last inserted interval with the maximum(current interval’s end,
    last inserted interval’s end) and continue moving afterward.
    Case 2: If the current interval cannot be merged with the last inserted interval of the answer list:
    In this case, we will insert the current interval in the answer array as it is. And after this insertion,
    the last inserted interval of the answer list will obviously be updated to the current interval.
4. Thus the answer list will be updated with the merged intervals and finally, we will return the answer list.
 */

// Time & Space Complexity : Optimal Solution
/*
Time Complexity: O(N*logN) + O(N), where N = the size of the given array.
Reason: Sorting the given array takes  O(N*logN) time complexity. Now, after that, we are just using a single
loop that runs for N times. So, the time complexity will be O(N).

Space Complexity: O(N), as we are using an answer list to store the merged intervals. Except for the answer array,
 we are not using any extra space.
 */