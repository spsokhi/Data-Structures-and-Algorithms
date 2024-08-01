//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        PrintWriter out=new PrintWriter(System.out);
        //taking testcases
        int t = Integer.parseInt(br.readLine()); 
    	for(int i=0;i<t;i++)
    	{
            String str=br.readLine();
    		String[] starr=str.split(" ");
    		
    		//input n and d
    	    int n=Integer.parseInt(starr[0]);
    		int d= Integer.parseInt(starr[1]);
    		
            int[] arr=new int[n];
    		String str1=br.readLine();
    		String[] starr1=str1.split(" ");
    		
    		//inserting elements in the array
    		for(int j=0;j<n;j++)
    		{
    		  arr[j]= Integer.parseInt(starr1[j]);
    		}
    		
    		//calling rotateArr() function
            new Solution().rotateArr(arr, d, n);
    		StringBuffer sb=new StringBuffer();
    		
    		//printing the elements of the array
            for(int t1=0;t1<n;t1++)
                sb.append(arr[t1]+" ");
            out.println(sb);
         }
         out.close();
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    //Function to rotate an array by d elements in counter-clockwise direction. 
    static void rotateArr(int a[], int d, int n)
    {
        // add your code here
        d%=n;
        reverse(a,0,d-1);
        reverse(a,d,n-1);
        reverse(a,0,n-1);
        
    }
      static void reverse(int a[], int low, int high){
          while(low<high){
              int tmp=a[low];
              a[low]=a[high];
              a[high]=tmp;
              low++;
              high--;
          }
      }
      
}