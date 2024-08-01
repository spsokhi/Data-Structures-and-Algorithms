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
                    String s = sc.next();
                    Solution obj = new Solution();
                    System.out.println(obj.longestPalinSubseq(s));
                }
                
        }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    static int solver(int n, int m, String str1, String str2,int [][] dp) {
     
          if(m==0||n==0)
        return 0;
        if(dp[n][m]!=-1)
        return dp[n][m];
        if(str1.charAt(n-1)==str2.charAt(m-1)){
             dp[n][m] =1+solver(n-1,m-1,str1,str2,dp);
        }
        else{
              dp[n][m]= Math.max(solver(n,m-1,str1,str2,dp),
                            solver(n-1,m,str1,str2,dp));
        }
        return dp[n][m];
         
     }
    public int longestPalinSubseq(String str1)
    {
        //code here
        int n=str1.length();
         int m=str1.length();
         
        String str2="";
        for(int i=n-1;i>=0;i--)
        str2+=str1.charAt(i);
    
         int dp[][]=new int [n+1][m+1];
        for(int i=0;i<=n;i++)
        Arrays.fill(dp[i],-1);
        return solver(n,m,str1,str2,dp);
       
    }
}