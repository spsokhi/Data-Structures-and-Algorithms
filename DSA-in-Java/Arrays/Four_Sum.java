package Arrays;

import java.util.*;

public class Four_Sum {

    // Method 1 - Brute Force (Using 4 loops)
    // Time Complexity: O(N^4), Space Complexity: O(2 * no. of the quadruplets) as we are using a set data
    // structure and a list to store the quads.
    public static List<List<Integer>> fourSum1(int[] nums, int target) {
        int n = nums.length; // size of the array
        Set<List<Integer>> set = new HashSet<>();

        // checking all possible quadruplets:
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    for (int l = k + 1; l < n; l++) {
                        // taking bigger data type
                        // to avoid integer overflow:
                        long sum = (long)nums[i] + nums[j];
                        sum += nums[k];
                        sum += nums[l];

                        if (sum == target) {
                            List<Integer> temp = Arrays.asList(nums[i], nums[j], nums[k], nums[l]);
                            Collections.sort(temp);
                            set.add(temp);
                        }
                    }
                }
            }
        }
        // To return the answer
        List<List<Integer>> ans = new ArrayList<>(set);
        return ans;
    }

    // Method 2 - Better Solution (Using 3 loops and a HashSet)
    // TIme Complexity:  O(N3*log(M)), where N = size of the array, M = no. of elements in the set.
    // Reason: Here, we are mainly using 3 nested loops, and inside the loops there are some operations on the set
    // data structure which take log(M) time complexity.
    // Space Complexity: O(2 * no. of the quadruplets)+O(N)
    // Reason: we are using a set data structure and a list to store the quads. This results in the first term. And the
    // second space is taken by the set data structure we are using to store the array elements. At most, the set can contain approximately all the array elements and so the space complexity is O(N).
    public static List<List<Integer>> fourSum2(int[] nums, int target) {
        int n = nums.length; // size of the array
        Set<List<Integer>> st = new HashSet<>();

        // checking all possible quadruplets:
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                Set<Long> hashset = new HashSet<>();
                for (int k = j + 1; k < n; k++) {
                    // taking bigger data type
                    // to avoid integer overflow:
                    long sum = nums[i] + nums[j];
                    sum += nums[k];
                    long fourth = target - sum;
                    if (hashset.contains(fourth)) {
                        List<Integer> temp = new ArrayList<>();
                        temp.add(nums[i]);
                        temp.add(nums[j]);
                        temp.add(nums[k]);
                        temp.add((int) fourth);
                        temp.sort(Integer::compareTo);
                        st.add(temp);
                    }
                    // put the kth element into the hashset:
                    hashset.add((long) nums[k]);
                }
            }
        }
        List<List<Integer>> ans = new ArrayList<>(st);
        return ans;
    }

    // Method 3 - Best Solution (Using 2 loops and 2 pointers)
    // Time Complexity: O(N3), where N = size of the array.
    // Reason: Each of the pointers i and j, is running for approximately N times. And both the pointers k
    // and l combined can run for approximately N times including the operation of skipping duplicates.
    // So the total time complexity will be O(N^3).
    // Space Complexity: O(no. of quadruplets), This space is only used to store the answer. We are not using any extra
    // space to solve this problem. So, from that perspective, space complexity can be written as O(1).
    static List<List<Integer>> fourSum3(int[] nums, int target) {
        int n = nums.length; // size of the array
        List<List<Integer>> ans = new ArrayList<>();

        // sort the given array:
        Arrays.sort(nums);

        // calculating the quadruplets:
        for (int i = 0; i < n; i++) {
            // avoid the duplicates while moving i:
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            for (int j = i + 1; j < n; j++) {
                // avoid the duplicates while moving j:
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;

                // 2 pointers:
                int k = j + 1;
                int l = n - 1;
                while (k < l) {
                    long sum = nums[i];
                    sum += nums[j];
                    sum += nums[k];
                    sum += nums[l];
                    if (sum == target) {
                        List<Integer> temp = new ArrayList<>();
                        temp.add(nums[i]);
                        temp.add(nums[j]);
                        temp.add(nums[k]);
                        temp.add(nums[l]);
                        ans.add(temp);
                        k++;
                        l--;

                        // skip the duplicates:
                        while (k < l && nums[k] == nums[k - 1]) k++;
                        while (k < l && nums[l] == nums[l + 1]) l--;
                    } else if (sum < target) k++;
                    else l--;
                }
            }
        }
        return ans;
    }

    // Main Function
    public static void main(String[] args) {
        int[] arr = {1,0,-1,0,-2,2};
        int target = 0;
        // int[] arr = {1, 1, 1, 2, 2, 2, 3, 3, 3, 4, 4, 4, 5, 5};
        // int target = 8;
        System.out.println(fourSum3(arr, target));
    }
}

// Output
// [[-2, -1, 1, 2], [-2, 0, 0, 2], [-1, 0, 0, 1]]
// [[1, 1, 1, 5], [1, 1, 2, 4], [1, 2, 2, 3], [1, 1, 3, 3]]

// Algorithm : Brute Force (Using 4 loops)
/*
1. First, we will declare a set data structure as we want unique quadruplets.
2. Then we will use the first loop(say i) that will run from 0 to n-1.
3. Inside it, there will be the second loop(say j) that will run from i+1 to n-1.
4. Then there will be the third loop(say k) that runs from j+1 to n-1.
5. Inside loop k, the fourth loop(say l) will run from k+1 to n-1.
6. Now, inside these four nested loops, we will check the sum i.e. arr[i]+arr[j]+arr[k]+arr[l], and if it is equal to the
target we will sort this quadruplet and insert it in the set data structure.
7. Finally, we will return a list of stored quadruplets.

Intuition: This approach is pretty straightforward. Here, we will check all possible quadruplets using 4 loops
(as we did in the 3-sum problem) and among them, we will consider the ones whose sum is equal to the given
target. And before considering them as our answer we need to sort the quadruplets in ascending order.
 */

// Algorithm : Better Solution (Using 3 loops and a HashSet)
/*
1. First, we will declare a set data structure as we want unique quadruplets.
2. Then we will use the first loop(say i) that will run from 0 to n-1.
3. Inside it, there will be the second loop(say j) that will run from i+1 to n-1.
4. Before the third loop, we will declare a HashSet to store the specific array elements as we intend to search the
fourth element in that HashSet.
5. Then there will be the third loop(say k) that runs from j+1 to n-1.
6. Inside the third loop, we will calculate the value of the fourth element i.e. target – (nums[i]+nums[j]+nums[k]).
7. If the fourth element exists in the HashSet, we will sort these four values i.e. nums[i], nums[j], nums[k], and the
fourth element, and insert it in the set data structure declared in step 1.
8. After that, we will insert the k-th element i.e. nums[k] in the HashSet as we only want to insert those array
elements that are in between indices j and k.
9. Finally, we will return a list of stored quadruplets stored in the set data structure.

Intuition:
In the previous approach, we were using 4 loops but in this, we want to reduce that to 3 loops. We have to somehow
manage to calculate nums[l] as we are planning to remove the fourth loop(i.e. l). In order to calculate
nums[l], we can derive a formula like the following:

nums[l] = target - (nums[i]+nums[j]+nums[k])
So, we will first calculate the triplets nums[i], nums[j], and nums[k] using 3 loops and for the fourth one i.e.
nums[l] we will not use another loop and instead we will look up the value target-(nums[i]+nums[j]+nums[k])
in the array. Thus we can remove the fourth loop from the algorithm.

For implementing the search operation of the fourth element, we will use a similar technique as we used in
the case of the 3-sum problem. We will store all the elements between the indices j and k in a HashSet
and then we will search for the fourth element in the HashSet.

// Edge Cases :
Why we are not inserting all the array elements in the HashSet and then searching for the fourth element:

Let’s understand this intuition using an example. Assume the given array is {1, 2, -1, -2, 2, 0, -1} and the
target = 0. Now, we will notice a situation like the following:              i      j         k

Now, the fourth element should be target-(nums[i]+nums[j]+nums[k]) = 0 – (1-1+0) = 0. Now, if all the array
elements are in the HashSet and we search for 0, we will end up taking the 0 at index k again. The quadruplets
will be {nums[i], nums[j], nums[k], nums[k]} but this is absolutely incorrect. That is why we need to only
consider the elements that are in between the indices j and k.
 */

// Algorithm : Optimal Solution (Using 2 loops and 2 pointers)
/*
1. First, we will declare a set data structure as we want unique quadruplets.
2. Then we will use the first loop(say i) that will run from 0 to n-1.
3. Inside it, there will be the second loop(say j) that will run from i+1 to n-1.
4. Then there will be the third loop(say k) that runs from j+1 to n-1.
5. Inside loop k, the fourth loop(say l) will run from k+1 to n-1.
6. Now, inside these four nested loops, we will check the sum i.e. arr[i]+arr[j]+arr[k]+arr[l], and if it is equal to the
target we will sort this quadruplet and insert it in the set data structure.
7. Finally, we will return a list of stored quadruplets.
 */

// Striver (Video Explanation) : https://youtu.be/eD95WRfh81c