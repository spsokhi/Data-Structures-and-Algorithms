package Arrays;

public class Stock_Buy_and_Sell_I {


    // Method 1: Brute Force
    // Time - O(N^2), Space - O(1)
//    static int maximize (int[] arr, int n) {
//        int maxProfit = 0;
//        for (int i=0; i<n; i++) {
//            for (int j=i+1; j<n; j++) {
//                if (arr[j] - arr[i] > maxProfit) {
//                    maxProfit = arr[j] - arr[i];
//                }
//            }
//        }
//        return maxProfit;
//    }

    // Method 2: Better Solution (Using temp array)
    // Time - O(N), Space - O(N)
//    static int maximize (int[] arr, int n) {
//        int[] temp = new int[n];
//
//        temp[n-1] = arr[n-1];
//
//        for (int i=n-2; i>=0; i--) {
//            temp[i] = Math.max(arr[i], temp[i+1]);
//        }
//
//        int j = 0;
//        int maxProfit = 0;
//        for (int i=0; i<n; i++) {
//            maxProfit = Math.max(maxProfit, temp[j] - arr[i]);
//            j++;
//        }
//        return maxProfit;
//    }

    // Method 3 - Optimal Solution (Using minPrice and maxProfit)
    // Time - O(N), Space - O(1)
    static int maximize (int[] arr, int n) {
        int minPrice = arr[0];
        int maxProfit = 0;

        for (int i=0; i<n; i++) {
            minPrice = Math.min(arr[i], minPrice);
            int profit = arr[i] - minPrice;
            maxProfit = Math.max(maxProfit, profit);
        }
        return maxProfit;
    }

    // Main Function
    public static void main(String[] args) {
        int[] arr = {7, 1, 5, 6, 3, 4};
        int n = arr.length;

        int res = maximize(arr, n);
        System.out.println(res);
    }
}

// Output:
// 5

// Algorithm: Brute Force
/*
1. Initialize maxProfit = 0
2. Run a loop from i = 0 to n-1
    a. Run a loop from j = i+1 to n-1
        i. If arr[j] - arr[i] > maxProfit, then update maxProfit
3. Return maxProfit
 */

// Algorithm: Better Solution (Using temp array)
// Idea - Find the maximum element in the right side (Preprocessing)
/*
1. Initialize temp array of size n
2. Initialize temp[n-1] = arr[n-1]
3. Run a loop from i = n-2 to 0
    a. temp[i] = max(arr[i], temp[i+1])
4. Initialize j = 0
5. Initialize maxProfit = 0
6. Run a loop from i = 0 to n-1
    a. maxProfit = max(maxProfit, temp[j] - arr[i])
    b. j++
7. Return maxProfit
 */

// Algorithm: Optimal Solution (Using minPrice and maxProfit)
// Idea : To sell this everyday, and we will see what was the minimum price before this day
// Suppose if we sell on 4th day, then we will see what was the minimum price before 4th day
// and then we will see what is the profit on 4th day, after selling
/*
1. Initialize minPrice = arr[0]
2. Initialize maxProfit = 0
3. Run a loop from i = 0 to n-1
    a. minPrice = min(arr[i], minPrice)
    b. profit = arr[i] - minPrice
    c. maxProfit = max(maxProfit, profit)
4. Return maxProfit
 */

// Anuj Bhaiya Video Link: https://youtu.be/34WE6kwq49U