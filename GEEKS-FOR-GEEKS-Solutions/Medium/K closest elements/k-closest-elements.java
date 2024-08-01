//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

public class GFG {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            inputLine = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }
            inputLine = br.readLine().trim().split(" ");
            int k = Integer.parseInt(inputLine[0]);
            int x = Integer.parseInt(inputLine[1]);

            int[] ans = new Solution().printKClosest(arr, n, k, x);
            for (int xx : ans) {
                System.out.print(xx + " ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {

    int[] printKClosest(int[] a, int n, int k, int x) {

        // lower bound

        int l=0,h=n-1;

        while(l<=h){

            int m=(l+h)/2;

            if(a[m]==x){

                l=m;

                break;

            }else if(a[m]<x)

                l=m+1;

            else

                h=m-1;

        }

        int[] ans=new int[k];

        int c=0, lc=0,rc=0;

        if(l>=0 && l<n && a[l]==x){

            lc=l-1;

            rc=l+1;

        }else{

            lc=l-1;

            rc=l;

        }

        while(lc>=0 && rc<n && c<k){

            if(x-a[lc] < a[rc]-x)

               ans[c++]=a[lc--];

            else

               ans[c++]=a[rc++];

        }

        if(lc<0){

            for(int i=rc;c<k;i++)

                ans[c++]=a[i];

        }else if(rc>=n){

            for(int i=lc;c<k;i--)

                ans[c++]=a[i];

 

      }

        return ans;

    }

}