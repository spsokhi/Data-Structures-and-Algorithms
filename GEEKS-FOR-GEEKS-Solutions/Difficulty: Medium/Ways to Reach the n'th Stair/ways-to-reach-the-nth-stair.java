//{ Driver Code Starts
import java.io.*;
import java.util.*;


class GFG {
	public static void main (String[] args) {
		
		//taking input using Scanner class
		Scanner sc = new Scanner(System.in);
		
		//taking total testcases
		int t = sc.nextInt();
		
		while(t-- > 0){
		    
		    //taking count of stairs
		    int m = sc.nextInt();
		    
		    //creating an object of class DynamicProgramming
		    Solution obj = new Solution();
		    
		    //calling method countWays() of class
		    //DynamicProgramming
		    System.out.println(obj.countWays(m));
		    
		}
		
	}
}
// } Driver Code Ends


class Solution
{
    //Function to count number of ways to reach the nth stair.
    static int mod=1000000007;
    int solver(int n,int dp[]){
        if(n<0) return 0;
        if(n==0)
        return 1;
        
        if(dp[n]!=-1)
        return dp[n]%1000000007;
        
        return dp[n]=(solver(n-1,dp)%1000000007+solver(n-2,dp)%1000000007)%1000000007;
    }
    int countWays(int n)
    {
        
        // your code here
       int dp[]=new int[n+1];
       Arrays.fill(dp,-1);
       return solver(n,dp);
    }
}

