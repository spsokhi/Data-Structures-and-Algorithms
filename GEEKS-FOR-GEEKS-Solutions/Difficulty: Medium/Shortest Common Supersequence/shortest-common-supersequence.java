//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
class GFG {
	public static void main (String[] args) {
	    
	    //taking input using Scanner class
		Scanner sc=new Scanner(System.in);
		
		//taking total testcases
		int t=sc.nextInt();
		
		sc.nextLine();
		while(t-->0)
		{
		   //taking String X and Y
		   String S[]=sc.nextLine().split(" ");
		   String X=S[0];
		   String Y=S[1];
		   
		   //calling function shortestCommonSupersequence()
		   System.out.println(new Solution().shortestCommonSupersequence(X, Y, X.length(), Y.length()));
		}
	}




       
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    //Function to find length of shortest common supersequence of two strings.
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
    
    public static int shortestCommonSupersequence(String X,String Y,int m,int n)
    {
        //Your code here
               int dp[][]=new int[m+1][n+1];
               for(int i=0;i<=m;i++){
                   Arrays.fill(dp[i],-1);
               }
               int res=solver(X,Y,m,n,dp);
               return m+n-res;

        
      
    }
}