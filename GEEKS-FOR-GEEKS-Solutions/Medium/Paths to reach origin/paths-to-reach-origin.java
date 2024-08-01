//{ Driver Code Starts
//Initial Template for Java


import java.io.*;
import java.util.*;


// } Driver Code Ends
//User function Template for Java


class Solution
{
    public static int ways(int n, int m)
    {
        // complete the function
        int arr[][]= new int[n+1][m+1];

        int x, y;

        for (x=1;x<=m;x++) 

        arr[0][x]=1;

        for(y=1;y<=n;y++) 

        arr[y][0]=1;

        arr[0][0]=0;

        for(y=1;y<=n;y++) 

        {

            for(x=1;x<=m;x++)

            arr[y][x]=(arr[y-1][x]+arr[y][x-1])%1000000007;

        }

        return arr[n][m];
    }
}

//{ Driver Code Starts.

// Driver class
class Array {
    
    // Driver code
	public static void main (String[] args) throws IOException{
		// Taking input using buffered reader
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testcases = Integer.parseInt(br.readLine());
		// looping through all testcases
		while(testcases-- > 0){
		    String line = br.readLine();
		    String[] elements = line.trim().split("\\s+");
		    int x=Integer.parseInt(elements[0]);
		    int y=Integer.parseInt(elements[1]);
		    Solution ob = new Solution();
		    System.out.println(ob.ways(x,y));
		}
	}
}
// } Driver Code Ends