//{ Driver Code Starts
import java.io.*;
import java.util.*;


class IntArray
{
    public static int[] input(BufferedReader br, int n) throws IOException
    {
        String[] s = br.readLine().trim().split(" ");
        int[] a = new int[n];
        for(int i = 0; i < n; i++)
            a[i] = Integer.parseInt(s[i]);

        return a;
    }

    public static void print(int[] a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }

    public static void print(ArrayList<Integer> a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            int n;
            n = Integer.parseInt(br.readLine());
            
            
            int d;
            d = Integer.parseInt(br.readLine());
            
            
            int[] arr = IntArray.input(br, n);
            
            Solution obj = new Solution();
            int res = obj.countPartitions(n, d, arr);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends



class Solution {
    static int mod = (int) 1e9+7;
    public static int countPartitions(int n, int d, int[] arr) {
        // code here
        int sum = 0;
        for(int num : arr) sum += num;
        if( (sum-d) % 2 == 1) return 0;
        int half = (sum-d)/2;
        if(half < 0) return 0;
        int[][] dp = new int[n][half+1];
        for(int[] temp : dp) {
            Arrays.fill(temp, -1);
        }
        return helper(half, 0, n, arr, 0, dp)%mod;
        
    }
    
    private static int helper(int sum, int temp, int n, int[] arr, int idx, int[][] dp) {
        if(idx == n || temp > sum) {
            if(sum == temp) return 1;
            return 0;
        } 
        if(dp[idx][temp] != -1) return dp[idx][temp]%mod;
        int ans = 0;
        ans += helper(sum, temp+arr[idx], n, arr, idx+1, dp);
        ans += helper(sum, temp, n, arr, idx+1,dp);
        return dp[idx][temp] = ans%mod;
    }
}