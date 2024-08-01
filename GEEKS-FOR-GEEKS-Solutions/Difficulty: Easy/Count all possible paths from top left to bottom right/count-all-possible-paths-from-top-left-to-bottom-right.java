//{ Driver Code Starts
//Initial Template for Java
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] input = new String[2]; 
            input = br.readLine().split(" "); 
            int m = Integer.parseInt(input[0]); 
            int n = Integer.parseInt(input[1]); 
            Solution ob = new Solution();
            System.out.println(ob.numberOfPaths(m,n));
        }
    }
}

// } Driver Code Ends


//User function Template for Java
class Solution
{       static int mod=1000000007;
    long solver(int m,int n, long dp[][]){
        if (m == 1 || n == 1) {
            return 1;
        }

        if (dp[m][n] != -1)
            return dp[m][n];

   



        return dp[m][n]=(solver(m, n - 1, dp)%mod+solver(m-1, n , dp)%mod)%mod;
    }

    long numberOfPaths(int m, int n) {
        long dp[][] = new long[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            Arrays.fill(dp[i], -1);
        }

        return solver(m, n, dp);
    }
}