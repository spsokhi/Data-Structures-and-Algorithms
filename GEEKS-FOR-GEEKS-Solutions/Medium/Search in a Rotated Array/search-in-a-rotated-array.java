//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;

public class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        
        int t = Integer.parseInt(in.readLine().trim());
        while (t-- > 0)
        {
            int n = Integer.parseInt(in.readLine().trim());
            int A[] = new int[n];
            String s[]=in.readLine().trim().split(" ");
            for (int i = 0;i < n;i++)
            {
                A[i] = Integer.parseInt(s[i]);
            }
            int key = Integer.parseInt(in.readLine().trim());
            
            out.println(new Solution().search(A, 0, n - 1, key));
        }
        out.close();
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    int search(int A[], int l, int h, int k)
    {
        // l: The starting index
        // h: The ending index, you have to search the key in this range
        // Complete this function
        while(l<=h){
            
            int mid=(l+h)/2;
            if(A[mid]==k) return mid;
            
            if(A[l]<=A[mid]){
                if(k>=A[l]&&k<A[mid])
                h=mid-1;
                else
                l=mid+1;
            }
            
             else{
                 if(k>A[mid]&&k<=A[h])
                 l=mid+1;
                 
                 else
                 h=mid-1;
             }
        }
        return -1;
    }
}