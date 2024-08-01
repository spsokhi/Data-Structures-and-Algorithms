//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
class GFG {
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		
		int t=sc.nextInt();
		
		while(t-->0)
		{
		    int n=sc.nextInt();
		    int a[]=new int[n];
		    
		    for(int i=0;i<n;i++)
		    {
		        a[i]=sc.nextInt();
		    }
		    int m=sc.nextInt();
		    Solution ob = new Solution();
		    System.out.println(ob.findPages(a,n,m));
		}
	}
}
// } Driver Code Ends


//User function Template for Java

class Solution 
{
    //Function to find minimum number of pages.
    public static int findPages(int[]A,int N,int k)
    {
        //Your code here
        if(k>N) return -1;
        int min=A[0];
        int max=0;
        for(int i=0;i<N;i++){
            min=Math.max(A[i],min);
            max+=A[i];
        }
        int res=0;
        
        while(min<=max){
            int mid=(min+max)/2;
            if(feasible(A,k,mid)){
                res=mid;
                max =mid-1;
            }
            else {
                min=mid+1;
            }
        }
        return res;
    }
    public static boolean feasible(int A[], int k,int res){
        int student =1;
        int sum=0;
        for(int i=0;i<A.length;i++){
            if((sum+A[i])>res){
                student++;
                sum=A[i];
            }
            else 
            sum+=A[i];
            
        }
        return student <=k;
        
    }
};