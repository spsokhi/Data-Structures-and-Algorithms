//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*; 
class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0){
            int n = Integer.parseInt(read.readLine());
            String str = read.readLine().strip();
            Solution ob = new Solution();
            long ans = ob.minDeletions(str, n); 
            System.out.println(ans);
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
    int minDeletions(String str1, int n)
    {
        // code here
      
         
        String str2="";
        for(int i=n-1;i>=0;i--)
        str2+=str1.charAt(i);
    
         int dp[][]=new int [n+1][n+1];
        for(int i=0;i<=n;i++)
        Arrays.fill(dp[i],-1);
        int temp= solver(n,n,str1,str2,dp);
        return n-temp;
    }
} 