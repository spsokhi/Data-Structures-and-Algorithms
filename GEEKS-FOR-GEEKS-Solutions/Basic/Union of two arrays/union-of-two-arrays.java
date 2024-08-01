//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GFG {
	public static void main (String[] args) {
	    
	    //Taking input using class Scanner
		Scanner sc=new Scanner(System.in);
		
		//Taking total count of testcases
		int t=sc.nextInt();
		sc.nextLine();
		while(t-->0)
		{
		    
		    int n,m;
		    
		    //taking size of array a
		    n=sc.nextInt();
		    
		    //taking size of array b
		    m=sc.nextInt();
		    
		    //Creating 2 array of size n and m
		    int a[]=new int[n];
		    int b[]=new int[m];
		    
		    //inserting elements to array a
		    for(int i=0;i<n;i++)
		    {
		        a[i]=sc.nextInt();
		    }
		    
		    //inserting elements to array b
		    for(int i=0;i<m;i++)
		    {
		        b[i]=sc.nextInt();
		    }
		    Solution ob=new Solution();
		    //calling doUnion method and printing the results
		    System.out.println(ob.doUnion(a,n,b,m));
		}
		
	}
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    public static int doUnion(int a[], int n, int b[], int m) 
    {
        //Your code here
        // ArrayList<Integer> li=new ArrayList<Integer>();
        // int i=0;
        // int j=0;
        // while(i<n&&j<m){
        //     if(a[i]<=b[j]){
        //         if(li.size()==0||li.get(li.size()-1)!=a[i])
        //             li.add(a[i]);
        //             i++;
                
        //     }
        //     else{
        //       if(li.size()==0||li.get(li.size()-1)!=b[j])
        //             li.add(b[j]);
        //             j++;
                
        //     }
            
        // }
        // while(j<m){
        //      if(li.size()==0||li.get(li.size()-1)!=b[j])
        //             li.add(b[j]);
        //         j++;
        // }
        // while(i<n){
        //      if(li.size()==0||li.get(li.size()-1)!=a[i])
        //             li.add(a[i]);
        //             i++;
            
        // }
        // return li.size();
        HashSet<Integer> union =new HashSet<Integer>();
        for(int i:a)
        union.add(i);
        
        for(int i:b)
        union.add(i);
        
        return union.size();
    }
}