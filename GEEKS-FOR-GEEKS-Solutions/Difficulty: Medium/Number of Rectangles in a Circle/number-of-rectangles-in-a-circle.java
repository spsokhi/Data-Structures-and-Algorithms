//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());
            Solution ob = new Solution();
            int ans = ob.rectanglesInCircle(N);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    int rectanglesInCircle(int r) {
        // code here
        int count = 0;
        double area = Math.PI*r*r;
        
        for(int i=1; i<=2*r; i++){
            for(int j=1; j<=2*r; j++){
                double currArea = i*j;
                if(canFit(i, j, r)){
                    count++;
                }
            }
        }
        return count;
    }
    
// Determine if it current rectangle can fit inside circle 
    boolean canFit(int i, int j, int r){
        double diagonal = Math.sqrt(i*i + j*j);
        return diagonal <= 2*r;
    }
};