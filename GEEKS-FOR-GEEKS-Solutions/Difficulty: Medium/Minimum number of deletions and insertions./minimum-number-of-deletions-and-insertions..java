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
                    String s1 = sc.next();
                    String s2 = sc.next();
                    Solution ob = new Solution();
                    System.out.println(ob.minOperations(s1,s2));
                }
        }
}    
// } Driver Code Ends


//User function Template for Java

class Solution
{
    
      public static int solver(String X,String Y,int m,int n,int dp[][]){
          
            if(m==0|| n==0)
        return 0;
        
        if(dp[m][n]!=-1){
            return dp[m][n];
        }
        if(X.charAt(m-1)==Y.charAt(n-1)){
             dp[m][n]=1+ solver(X,Y,m-1,n-1,dp);
        }
        else{
             dp[m][n] =Math.max(solver(X,Y,m,n-1,dp),
                            solver(X,Y,m-1,n,dp));
        }
        return dp[m][n];
      }
	public int minOperations(String str1, String str2) 
	{ 
	    // Your code goes here
	    int m=str1.length();
	    int n=str2.length();
	     int dp[][]=new int[m+1][n+1];
               for(int i=0;i<=m;i++){
                   Arrays.fill(dp[i],-1);
               }
               int res=solver(str1,str2,m,n,dp);
               int ans=m-res+n-res;
               return ans;

	} 
}