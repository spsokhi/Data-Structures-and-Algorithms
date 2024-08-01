//{ Driver Code Starts
import java.io.*;

import java.util.*;

class Main {
    
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim()); //Inputting the testcases
		while(t-->0){
		    //size of array
		    int n = Integer.parseInt(br.readLine().trim());
		    int arr[] = new int[n];
		    String inputLine[] = br.readLine().trim().split(" ");
		    
		    //adding elements
		    for(int i=0; i<n; i++){
		        arr[i] = Integer.parseInt(inputLine[i]);
		    }
		    
		    Solution obj = new Solution();
		    
		    //calling maxSubarraySum() function
		    System.out.println(obj.maxSubarraySum(arr, n));
		}
	}
}


// } Driver Code Ends




// class Solution{

//     // arr: input array
//     // n: size of array
//     //Function to find the sum of contiguous subarray with maximum sum.
//     long maxSubarraySum(int arr[], int n){
        
//         // Your code here
//         long curr_sum=0;
//         long max_sum=Long.MIN_VALUE;

//         for(int i=0;i<arr.length;++i){
//             curr_sum+=arr[i];
//             if(curr_sum>max_sum){
//                 max_sum=curr_sum;
//             }
//             if(curr_sum<0){
//                 curr_sum=0;
//             }
//         }
//       return max_sum;
//     }
    
// }
class Solution{

    long maxSubarraySum(int arr[], int n)
    {
         long sum=0;
        long maxi=Long.MIN_VALUE;
        for(int i=0;i<n;i++){
            sum+=arr[i];
            if(sum>maxi){
                maxi=sum;
            }
            if(sum<0){
                sum=0;
            }
        }
        return maxi;
    }
}
