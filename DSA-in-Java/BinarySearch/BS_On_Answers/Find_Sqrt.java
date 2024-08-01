package BinarySearch.BS_On_Answers;

public class Find_Sqrt {

    // Method 1 : Brute Force
    // Time - O(N), Space - O(1)
//    static int findSqrt(int n) {
//        int ans = 1;
//
//        for (int i=1; i<=n; i++) {
//            if (i * i <= n) {
//                ans = i;
//            }
//            else {
//                break;
//            }
//        }
//        return ans;
//    }

    // Method 2 : Optimal Solution 1 (Using BuiltIn Function : Math.sqrt())
    // Time - O(log2N), Space - O(1)
//    static int findSqrt(int n) {
//        int res = (int) Math.sqrt(n);
//        return res;
//    }

    // Method 3 : Optimal Solution 2 (Using Binary Search)
    // Time - O(log2N), Space - O(1)
    static int findSqrt(int n) {
        int low = 1;
        int high = n;
        int ans = 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            // eliminate the left half:
            if (mid * mid <= n) {
                ans = mid;
                low = mid+1;
            }
            // eliminate the right half:
            else {
                high = mid-1;
            }
        }
        return ans;
    }

    // Main Function
    public static void main(String[] args) {
        int n = 28;
        int ans = findSqrt(n);
        System.out.println("The floor of square root of " + n + " is: " + ans);
    }
}

// Output -
// The floor of square root of 28 is: 5

// Algorithm : Brute Force
/*
Algorithm / Intuition
Naive Approach(Using linear search):
We can guarantee that our answer will lie between the range from 1 to n i.e. the given number. So, we will perform a linear search on this range and we will find the maximum number x, such that x*x <= n.

Algorithm:
1. We will first declare a variable called ‘ans’.
2. Then, we will first run a loop(say i) from 1 to n.
3. Until the value i*i <= n, we will update the variable ‘ans’, with i.
4. Once, the value i*i becomes greater than n, we will break out from the loop as the current number i,
or the numbers greater than i, cannot be our answers.
5. Finally, our answer should have been stored in ‘ans’.
 */

// Algorithm : Optimal Solution 1 (Using BuiltIn Function : Math.sqrt())
/*
A straightforward solution to this problem is to utilize the built-in sqrt() function. This approach doesn’t
require any code implementation but serves as one of the possible solutions.
 */

// Algorithm : Optimal Solution 2 (Using Binary Search)
/*
Intuition:
Now, we are not given any sorted array on which we can apply binary search. But, if we observe closely,
we can notice that our answer space i.e. [1, n] is sorted. So, we will apply binary search on the answer space.

Algorithm:
The steps are as follows:

We will declare a variable called ‘ans’.

1. Place the 2 pointers i.e. low and high: Initially, we will place the pointers. The pointer low will point to 1 and
the high will point to n.
2. Calculate the ‘mid’: Now, inside a loop, we will calculate the value of ‘mid’ using the following formula:
mid = (low+high) // 2 ( ‘//’ refers to integer division)
3. Eliminate the halves accordingly:
    1. If mid*mid <= n: On satisfying this condition, we can conclude that the number ‘mid’ is one of the possible
     answers. So, we will store ‘mid’ in the variable ‘ans’. But we want the maximum number that holds this condition.
     So, we will eliminate the left half and consider the right half(i.e. low = mid+1).
    2. Otherwise, the value mid is larger than the number we want. This means the numbers greater than ‘mid’ will not
     be our answers and the right half of ‘mid’ consists of such numbers. So, we will eliminate the right half and
     consider the left half(i.e. high = mid-1).
4. Finally, the ‘ans’ variable will be storing our answer. In addition to that, the high pointer will also point to
the same number i.e. our answer. So, we can return either of the ‘ans’ or ‘high’.

The steps from 2-3 will be inside a loop and the loop will continue until low crosses high.
 */

// Striver Video Explanation : https://www.youtube.com/watch?v=Bsv3FPUX_BA