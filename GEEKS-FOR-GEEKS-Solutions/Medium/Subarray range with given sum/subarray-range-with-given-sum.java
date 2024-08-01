//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.lang.*;
import java.io.*;

class Driverclass
{
	public static void main (String[] args)
	 {
    	 Scanner sc=new Scanner(System.in);
    	 int t=sc.nextInt();
    	 while(t-->0)
    	 {
    	        int n = sc.nextInt();
    		    int arr[] = new int[n];
    		    for(int i=0;i<n;i++)
    		    {
    		        arr[i] = sc.nextInt();
    		    }
    		    int sum = sc.nextInt();
    		    System.out.println(new Solution().subArraySum(arr, n, sum));
    		    
    		}
	}
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    //Function to count the number of subarrays which adds to the given sum.
    static int subArraySum(int a[], int n, int sum)
    {
        // add your code here
        // int start=0;
        // int end=-1;
        int currsum=0;
        int count=0;
        HashMap<Integer,Integer> mp=new HashMap<Integer,Integer>();
        for(int i=0;i<n;i++){
            currsum+=a[i];
        //     if(currsum-sum==0){
        //         // start=0;
        //         end=i;
        //         count++;
        //      continue;
        //     }
        //     if(mp.containsKey(currsum-sum)){
        //         start=mp.get(currsum-sum)+1;
        //         end=i;
        //         count++;
        //         continue;
        //     }
            // mp.put(currsum,i);
        // 
        
      if (currsum == sum) {
                count++;
            }
            if (mp.containsKey(currsum - sum)) {
                count += mp.get(currsum - sum);
            }
            mp.put(currsum, mp.getOrDefault(currsum, 0) + 1);
        }
        return count;
    }
}