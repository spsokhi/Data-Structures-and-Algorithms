//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            List<Integer> arr = new ArrayList<>();
            String input = br.readLine();
            StringTokenizer st = new StringTokenizer(input);
            while (st.hasMoreTokens()) {
                arr.add(Integer.parseInt(st.nextToken()));
            }
            Solution ob = new Solution();
            int ans = ob.findElement(arr);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java
class Solution {
    public int findElement(List<Integer> arr) {
    int n=arr.size();
        int[] rightSmallest = new int[n];
        int[] leftGreatest = new  int[n];
        
        leftGreatest[0] = arr.get(0);
        for (int i=1; i<n; i++){
            leftGreatest[i] = Math.max(leftGreatest[i-1], arr.get(i));
        }
       rightSmallest[n-1] = arr.get(n-1);
        for (int i=n-2; i>=0; i--){
            rightSmallest[i] = Math.min(rightSmallest[i+1], arr.get(i));
        }
        
        for (int i=1; i<n-1; i++){
             if (leftGreatest[i] == rightSmallest[i]) return arr.get(i);
        }
        
        return -1;
    
    }
}