//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG{
    public static void main(String args[]) throws IOException{
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int N=sc.nextInt();
            int []arr=new int[N];
            for(int i=0;i<N;i++){
                arr[i]=sc.nextInt();
                
            }
            Solution obj=new Solution();
            int res=obj.minimumEnergy(arr,N);
            System.out.println(res);
            
        }
    }
}


// } Driver Code Ends


//User function Template for Java

class Solution{

    public int minimumEnergy(int arr[],int n){
        //code here
        
        
        int dp[]= new int[n+1];
        Arrays.fill(dp,-1);
        dp[0]=0;
        for(int i=1;i<n;i++){
            int left=dp[i-1]+ Math.abs(arr[i-1]-arr[i]); 
            int right=Integer.MAX_VALUE;
              if(i>1)
        right=dp[i-2]+Math.abs(arr[i-2]-arr[i]);
        
        dp[i]= Math.min(left,right);
        }
        return dp[n-1];
    }
}