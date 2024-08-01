//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    // Driver code
    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            String[] str = br.readLine().trim().split(" ");
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(str[i]);
            }

            ArrayList<Integer> ans = new Solution().findSubarray(a, n);
            for(int i:ans){
                out.print(i+" ");
            }out.println();
        }
        out.close();
    }
}
// } Driver Code Ends




// User function Template for Java

class Solution {

    ArrayList<Integer> findSubarray(int a[], int n) {
        // code here
         ArrayList<Integer> li= new ArrayList<Integer>();
        int start=0,length=-1,maxstart=-1,end=-1;
        int temp=-1,max=-1;
        for(int i=0;i<n;i++){
            if(a[i]<0){
                start=-1;
                temp=-1;
            }
            else{
                if(temp==-1){
                    temp=a[i];
                    start=i;
                }
                else{
                    temp+=a[i];
                }
                 if(temp>max){
                    max=temp;
                    length=i-start+1;
                    maxstart=start;
                    end=i;
                    
                }
                else if((max==temp) && (i-start+1>length)){

                length=i-start+1;
                max=temp;
                 maxstart=start;
                    end=i;
            }}
        }
            if(maxstart==-1){
                li.add(-1);
            }
            else {
               for(int i=maxstart;i<=end;i++)
                   li.add(a[i]);
               
            }
        
        return li;

    }
}