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
            int n = Integer.parseInt(br.readLine().trim());
            String s = br.readLine().trim();
            String[] s1 = s.split(" ");
            int[] nums = new int[n];
            for(int i = 0; i < n; i++)
                nums[i] = Integer.parseInt(s1[i]);
            Solution ob = new Solution();
            long ans = ob.min_operations(nums);
            System.out.println(ans);            
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int min_operations(int []nums)
    {
        // Code here
        int[] dp= new int[nums.length];
        for(int i=0;i<nums.length;i++)dp[i]=1;
        
        dp[0]=1;
        int max=1;
        for(int i=1;i<nums.length;i++){
            int totalNumInBtw=0;
            for(int j=i-1;j>=0;j--){
                if(nums[j]<nums[i] && totalNumInBtw < nums[i]-nums[j] ){
                    dp[i]=dp[i]<(dp[j]+1)?dp[j]+1:dp[i];
                    if(dp[i]>max)max=dp[i];
                }
                totalNumInBtw++;
            }
            
        }
        return nums.length -max;
    }
}