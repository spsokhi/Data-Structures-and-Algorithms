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
                    Solution ob = new Solution();
                    System.out.println(ob.padovanSequence(n));
                }
        }
}    
// } Driver Code Ends


//User function Template for Java

class Solution
{
  public int padovanSequence(int n)
    {
        //code here.
         int z=1, o=1, t=1;
        int MOD = 1000000007;
        if(n<3) return 1;
        for(int i=3; i<=n; i++){
            int f = (z + o)%MOD;
            z=o;
            o=t;
            t=f;
        }
        return t%MOD;
    }
    
}
