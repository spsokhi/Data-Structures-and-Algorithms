//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int mat[][] = new int[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    mat[i][j] = sc.nextInt();
                }
            }
            Solution ob = new Solution();
            System.out.println(ob.maxSquare(n, m, mat));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    static int maxSquare(int n, int m, int mat[][]) {
        // code here
        int dp[][] = new int[n][m], max=0;
        for(int i=0;i<m;i++){
            dp[0][i]=mat[0][i];
            max=Math.max(max, mat[0][i]);
        }
        for(int i=0;i<n;i++){
            dp[i][0]=mat[i][0];
            max=Math.max(max, mat[i][0]);
        }
        for(int i=1;i<n;i++){
            for(int j=1;j<m;j++){
                if(mat[i][j]==0){
                    dp[i][j]=0;
                }
                else{
                    int min=Math.min(dp[i-1][j], dp[i][j-1]);
                    min=Math.min(min, dp[i-1][j-1])+1;
                    dp[i][j]=min;
                }
                max=Math.max(max, dp[i][j]);
            }
        }
        return max;
    }
}