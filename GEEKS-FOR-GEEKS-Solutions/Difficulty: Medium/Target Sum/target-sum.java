//{ Driver Code Starts
//Initial Template for JAVA

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());
            
            String S[] = read.readLine().split(" ");
            
            int[] A = new int[N];
            
            for(int i=0 ; i<N ; i++){
                A[i] = Integer.parseInt(S[i]);
            }
            int target = Integer.parseInt(read.readLine());

            Solution ob = new Solution();
            System.out.println(ob.findTargetSumWays(N,A, target));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    static int findTargetSumWays( int n, int[] nums ,int target) {
        // code here
         int sum = 0;
        for(int x : nums)
            sum += x;
        if(((sum - target) % 2 == 1) || (target > sum))
            return 0;
        
        int val= (sum - target)/2;
        int[][] t = new int[n + 1][val + 1];
        t[0][0] = 1;
        
        for(int i = 1; i < n + 1; i++) {
            for(int j = 0; j < val + 1; j++) {
                if(nums[i - 1] <= j)
                    t[i][j] = t[i-1][j] + t[i - 1][j - nums[i - 1]];
                else
                    t[i][j] = t[i - 1][j];
            }
        }
        return t[n][val];
    }
};