//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            inputLine = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

    
            long ans = new Solution().maxProduct(arr, n);
            System.out.println(ans);
        }
    }
}


// } Driver Code Ends


//User function Template for Java

class Solution {
    long maxProduct(int[] arr, int n) {
      long max1=Long.MIN_VALUE;
      long max2=Long.MIN_VALUE;
      long max3=Long.MIN_VALUE;
      int index1=0,index2=0,index3=0;
      for (int num : arr) {
            if (num >= max1) {
                max3 = max2;
                max2 = max1;
                max1 = num;
            } else if (num >= max2) {
                max3 = max2;
                max2 = num;
            } else if (num >= max3) {
                max3 = num;
            }
        }
     long min1=Long.MAX_VALUE;
     long min2=Long.MAX_VALUE;
       for (int num : arr) {
            if (num <= min1) {
                 min2=min1;
               min1=num;
            } else if(num<=min2){
                min2=num;
            }
            else
            continue;
        }
  
      return Math.max(max1*max2*max3,max1*min1*min2);
    }
}