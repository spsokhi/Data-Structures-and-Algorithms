//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main(String[] args) throws IOException
	{
	        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t =
            Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while(t-->0)
        {
            StringTokenizer stt = new StringTokenizer(br.readLine());
            
            int n = Integer.parseInt(stt.nextToken());
            int k = Integer.parseInt(stt.nextToken());
            long a[] = new long[(int)(n)];
            String inputLine[] = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                a[i] = Long.parseLong(inputLine[i]);
            }
            
            Solution obj = new Solution();
            System.out.println(obj.maximizeSum(a, n, k));
            
        }
	}
}

// } Driver Code Ends


//User function Template for Java


class Solution {

    
    public static long maximizeSum(long a[], int n, int k) {
        
        Arrays.sort(a);
        
        for(int i=0;i<n;i++) {
            
            if(a[i]<0 && k>0) {
                a[i]*=-1;
                k--;
            }
        }
        
        Arrays.sort(a);
        
        long sum = 0;
        
        for(int i=0;i<n;i++)
            sum+=a[i];
     
        if(k%2==1)
            sum-=2*a[0];
        
        return sum;
    }
}