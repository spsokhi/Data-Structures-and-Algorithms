//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*; 

class GFG{
    public static void main(String args[]) throws IOException { 
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t > 0){
        	int n = sc.nextInt();
        	int[] array = new int[n];
        	for (int i=0; i<n ; i++ ) {
        		array[i] = sc.nextInt();
        	}
            Solution ob = new Solution();
            long[] ans = new long[n];
            ans = ob.productExceptSelf(array, n); 

           	for (int i = 0; i < n; i++) { 
				System.out.print(ans[i]+" ");
			} 
            System.out.println();
            t--;
        }
    } 
} 
  


// } Driver Code Ends


//User function Template for Java


class Solution 
{ 
	public static long[] productExceptSelf(int nums[], int n) 
    { 
        // code here
        long[] ans = new long[n];
        
        for(int i = 0 ; i < n;i++){
            //find product
            ans[i] = (long)multiply(i,nums);
        }
        return ans;
    
    }
    
    public static long multiply(int index, int[] nums){
        long multi = 1;
        //if same element,,do not multiply it
        for(int i = 0 ; i < nums.length ;i++){
            
            if(i == index){
                //same element found with the index,,we donot want it,,so i++
                continue;
            }
            else{
                multi *= (long)nums[i];
            }
        }
        return multi;
    }
} 
