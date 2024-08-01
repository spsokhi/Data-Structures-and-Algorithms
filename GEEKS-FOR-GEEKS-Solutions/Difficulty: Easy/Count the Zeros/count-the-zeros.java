//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while (t-- > 0) {

            String line = br.readLine();
            String[] tokens = line.split(" ");

            // Create an ArrayList to store the integers
            ArrayList<Long> array = new ArrayList<>();

            // Parse the tokens into integers and add to the array
            for (String token : tokens) {
                array.add(Long.parseLong(token));
            }

            int[] arr = new int[array.size()];
            int idx = 0;
            for (long i : array) arr[idx++] = (int)i;

            Solution obj = new Solution();

            // calling maxSubarraySum() function
            System.out.println(obj.countZeroes(arr));
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    int countZeroes(int[] arr) {
        // code here
        int n=arr.length;
          int start=0;
        int end=n-1;
        int mid;
        while(start<=end)
        {
            mid=(start+end)/2;
            if(arr[mid]==0)
            {
                end=mid-1;
            }
            else if(arr[mid]==1)
            {
                start=mid+1;
            }
        }
        return n-1-end;
    }
}
