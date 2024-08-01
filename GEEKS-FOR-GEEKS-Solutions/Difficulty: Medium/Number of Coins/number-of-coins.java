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
                    int v = sc.nextInt();
                    int m = sc.nextInt();
                    int coins[] = new int[m];
                    for(int i = 0;i<m;i++)
                        coins[i] = sc.nextInt();
                    Solution ob = new Solution();
                    System.out.println(ob.minCoins(coins, m, v));
                }
        }
}    
// } Driver Code Ends


class Solution{

	public int minCoins(int coins[], int n, int amount) 
	{ 
	    // Your code goes here
	    int dp[][]=new int[n+1][amount+1];
        
         for(int i = 0 ; i < n+1;i++)
            dp[i][0]=0;
        
        for(int j = 1 ; j < amount +1 ; j++)
            dp[0][j]=Integer.MAX_VALUE-1;
        
        for(int j =1 ; j < amount+1;j++)
        {
            if (j % coins[0]==0)
                dp[1][j]= j/coins[0];
            else
                dp[1][j]=Integer.MAX_VALUE-1;
            
        }
        
        for(int i =2; i<n+1;i++)
        {
            for (int j =1; j <amount+1;j++)
            {
                if (coins[i-1]<=j)
                    dp[i][j]=Math.min(dp[i][j-coins[i-1]]+1,dp[i-1][j]);
                
                else
                    dp[i][j]=dp[i-1][j];
            }
        }
        
        return dp[n][amount]!=Integer.MAX_VALUE-1 ? dp[n][amount] : -1;
        
    
	} 
}