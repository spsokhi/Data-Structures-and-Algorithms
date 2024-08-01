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
		    //taking the String
		    String s=sc.nextLine();
		    Solution ob = new Solution();
		    //calling method sumSubstrings() 
		    System.out.println(ob.sumSubstrings(s));
		}
	}
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    //Function to find sum of all possible substrings of the given string.
    static long mod = 10000_00007;
    public static long sumSubstrings(String s)
    {
    //Your code here
        int n = s.length();
        long prev = 0;
        long curr = 0;
        long sum = 0;
        for(int i = 0 ; i < n ; i++)
        {
            long res = (long)(s.charAt(i) - '0');
            curr = (res*(i+1)%mod + (prev*10)%mod)%mod;
            sum = (sum+curr)%mod;
            prev = curr;
        }
        return sum;
    }
}