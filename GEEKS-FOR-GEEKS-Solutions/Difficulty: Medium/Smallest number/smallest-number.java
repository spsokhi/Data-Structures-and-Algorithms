//{ Driver Code Starts
import java.util.*;

class GFG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();

        while (tc-- > 0) {
            int s = sc.nextInt();
            int d = sc.nextInt();

            Solution obj = new Solution();
            String res = obj.smallestNumber(s, d);

            System.out.println(res);
        }
    }
}
// } Driver Code Ends



class Solution {
   public String smallestNumber(int s, int d) {
        // code here
        String ans="";
        for (int i=1;i<=d;i++) { 
            for (int j=0;j<10;j++) { 
                if (i==1 && j==0) continue;
                if ((s-j)<=(d-i)*9) { 
                    ans+=j;
                    s-=j;
                    break;
                }
            }
        }
        
        if (s!=0) return "-1";
        
        return ans;
    }


}
