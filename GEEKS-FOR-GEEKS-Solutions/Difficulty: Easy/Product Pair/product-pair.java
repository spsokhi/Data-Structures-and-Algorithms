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
            long x = Long.parseLong(inputLine[1]);
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }
            boolean ans = new Solution().isProduct(arr, n, x);
            System.out.println(ans ? "Yes" : "No");
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution {
    boolean isProduct(int[] arr, int n, long x) {
        HashSet<Integer> map = new HashSet<>();
        for(int i = 0 ;i < n;i++)
        {
            if (arr[i] == 0) {
                if (x == 0) return true; 
                else continue; 
            }
          long mul = x / (long)arr[i];
            if(map.contains((int)mul) && x% (long) arr[i] == 0)
               return true;
               else
               {
                   map.add(arr[i]);
               }
        }
        return false;
    }
}