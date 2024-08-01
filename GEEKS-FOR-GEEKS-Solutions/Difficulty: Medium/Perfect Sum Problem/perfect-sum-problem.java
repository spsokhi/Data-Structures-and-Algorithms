//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    int n = sc.nextInt();
                    int sum = sc.nextInt();
                    int arr[] = new int[n];
                    for(int i = 0;i<n;i++)
                    arr[i] = sc.nextInt();
                    
                    Solution ob = new Solution();
                    System.out.println(ob.perfectSum(arr,n,sum));
                }
        }
}    
// } Driver Code Ends


class Solution {
    private static final int MOD = (int) 1e9 + 7;

    public int perfectSum(int arr[], int N, int sum) {
        int[][] dp = new int[N + 1][sum + 1];

        // Base case initialization
        dp[0][0] = 1; // One way to make sum 0: by choosing the empty subset

        // Fill the dp table
        for (int i = 1; i <= N; i++) {
            for (int j = 0; j <= sum; j++) {
                dp[i][j] = dp[i - 1][j]; // Exclude current element

                int remainder = j - arr[i - 1];
                if (remainder >= 0) {
                    dp[i][j] = (dp[i][j] + dp[i - 1][remainder]) % MOD; // Include current element
                }
            }
        }

        return dp[N][sum];
    }
}
