//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String input[] = read.readLine().trim().split(" ");
            int n = Integer.parseInt(input[0]);
            int m = Integer.parseInt(input[1]);
            
            String S1 = read.readLine().trim();
            String S2 = read.readLine().trim();

            Solution ob = new Solution();
            System.out.println(ob.longestCommonSubstr(S1, S2, n, m));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static int ans;
    Solution(){
        this.ans =Integer.MIN_VALUE;
    }
    static int solver(int n, int m, String str1, String str2,int [][] dp) {
       
          if(m==0||n==0)
        return 0;
        if(dp[n][m]!=-1)
        return dp[n][m];
        if(str1.charAt(n-1)==str2.charAt(m-1)){
             dp[n][m] =1+solver(n-1,m-1,str1,str2,dp);
             ans = Math.max(ans, dp[n][m]);
           
        }
        else{
              dp[n][m]= 0;
        }
        
              solver(n,m-1,str1,str2,dp);
              solver(n-1,m,str1,str2,dp);
        
           return dp[n][m];
     }
     
    int longestCommonSubstr(String S1, String S2, int n, int m){
        // code here
         int dp[][]=new int [n+1][m+1];
        for(int i=0;i<=n;i++)
        Arrays.fill(dp[i],-1);
       solver(n,m,S1,S2,dp);
        return ans==Integer.MIN_VALUE?0:ans;
        
    }
}