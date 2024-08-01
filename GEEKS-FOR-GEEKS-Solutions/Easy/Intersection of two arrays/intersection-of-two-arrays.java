//{ Driver Code Starts
// Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
class GFG {
    public static void main(String[] args) {

        // Taking input using class Scanner
        Scanner sc = new Scanner(System.in);

        // Taking count of total testcases
        int t = sc.nextInt();

        while (t-- > 0) {
            int n, m;

            // taking count of elements in array a
            n = sc.nextInt();

            // taking count of elements in array b
            m = sc.nextInt();

            // Creating 2 arrays of n and m
            int a[] = new int[n];
            int b[] = new int[m];

            // inserting elements to array a
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }

            // inserting elements to array b
            for (int i = 0; i < m; i++) {
                b[i] = sc.nextInt();
            }
            Solution ob = new Solution();
            // calling NumberofElementsInIntersection method
            // and printing the result
            System.out.println(ob.NumberofElementsInIntersection(a, b, n, m));
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    // Function to return the count of the number of elements in
    // the intersection of two arrays.
    public static int NumberofElementsInIntersection(int arr1[], int arr2[], int n, int m) {
        // Your code here
         HashSet<Integer> hs = new HashSet<>();
        HashSet<Integer> hs1 = new HashSet<>();
        int count=0;
 
        for (int i = 0; i < n; i++)
            hs.add(arr1[i]);
 
        for (int i = 0; i < m; i++)
            hs1.add(arr2[i]);
            
       hs.retainAll(hs1);
       return hs.size();
     
    }
}
