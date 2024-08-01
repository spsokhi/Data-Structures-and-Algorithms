//{ Driver Code Starts
//Initial Template for Java


import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            int n = Integer.parseInt(br.readLine().trim());
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            int ans = new Solution().findMaximum(arr, n);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java


class Solution {
    int findMaximum(int[] arr, int n) {
        // code here
        int low=0;
        int high=n-1;
        int mid = (low+high)/2;
        int ans=arr[n-1];
        
        while(low<high){
            if(arr[mid] < arr[mid+1]){
                low = mid+1;
            }
            else{
                high = mid;
                ans = arr[mid];
            }
            mid = (low+high)/2;
        }
        return ans;
    }
}

