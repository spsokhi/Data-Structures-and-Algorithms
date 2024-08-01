//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            String[] str = br.readLine().trim().split(" ");
            int[] array = new int[n - 1];
            for (int i = 0; i < n - 1; i++) {
                array[i] = Integer.parseInt(str[i]);
            }
            Solution sln = new Solution();
            System.out.println(sln.missingNumber(array, n));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    int missingNumber(int arr[], int n) {
        // Your Code Here
        // int sum1 = (n*(n+1))/2;
        // int sum2= 0;
        // for(int i=0;i<n-1;i++){
        //     sum2+=arr[i];
        // }
        // return sum1-sum2;
        
        int xor1=arr[0];
        int xor2=1;
        
        for(int i=1;i<n-1;i++)
            xor1=xor1^arr[i];
            
            for(int i=2;i<=n;i++)
            xor2=xor2^i;
        
     
        return xor1^xor2;
    }
}