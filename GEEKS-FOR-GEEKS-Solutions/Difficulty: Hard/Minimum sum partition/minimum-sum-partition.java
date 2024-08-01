//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    int n = sc.nextInt();
                    int A[] = new int[n];
                    for(int i = 0;i<n;i++)
                        A[i] = sc.nextInt();
                    Solution ob = new Solution();
                    System.out.println(ob.minDifference(A,n));
                }
        }
}    
// } Driver Code Ends


//User function Template for Java

class Solution
{
        
	public int minDifference(int arr[], int N) 
	{ 
	    // Your code goes here
        // code here
        
          int range=0;
	    for(int i=0;i<N;i++)
	    range+=arr[i];
	    
        boolean[][] t = new boolean[N+1][range+1];
        for (int i = 0; i< N+1 ; i ++){
            for (int j=0; j< range +1 ; j++){
                if(i == 0)
                    t[i][j]=false;
                if (j== 0)
                    t[i][j]=true;
            }
        }
        
        for (int i = 1; i< N+1 ; i ++){
            for (int j=1; j< range +1 ; j++){
                if (arr[i-1]<=j){
                 t[i][j]=((t[i-1][j-arr[i-1]] )||( t[i-1][j]));
                }
                else 
                    t[i][j]= (t[i-1][j]);
            }
            
        }
        
        ArrayList<Integer> li=new ArrayList<>();
        for(int i=0;i<(range/2)+1;i++){
            if(t[N][i]==true)
            li.add(i);
        }
        int sum=Integer.MAX_VALUE;
        for(int i=0;i<li.size();i++){
            sum=Math.min(sum,range-(2*li.get(i)));
            
        }
        return sum;
	} 
}
