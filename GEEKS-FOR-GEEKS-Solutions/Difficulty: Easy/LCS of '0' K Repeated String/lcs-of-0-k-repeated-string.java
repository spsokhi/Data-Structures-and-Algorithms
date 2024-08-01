//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int k = Integer.parseInt(in.readLine());
            String st = in.readLine();
            
            Solution ob = new Solution();
            System.out.println(ob.lcsK(k, st));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    
    static int lcsK(int k, String st){
        // code here
        int n=st.length();
        
        String tmp=st+st;
        
         int count=0;
        int max=-1;
        
        for(int i=0;i<2*n;i++){
              if(tmp.charAt(i)=='0')
                     count++;
                   
                  else   count=0;
                  
                  max=Math.max(max,count);
          }
            if(max==tmp.length())
            return k*(max-n);
        
        return max;
    }
}