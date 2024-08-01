//{ Driver Code Starts
//Initial Template for Java
import java.util.*;
import java.io.*;
class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(read.readLine());
            Solution ob = new Solution();

            System.out.println(ob.armstrongNumber(n));
        }
    }
}
// } Driver Code Ends


//User function Template for Java
class Solution {
    static String armstrongNumber(int n){
        // code here
        int t = n;
        int curr,cube = 0,sum = 0;

        while(t != 0) {
            curr = t%10; //take last integer
            cube = curr * curr * curr; //find cube
            if(cube>n) {
                return "No";
            }
            sum += cube; 
            t /= 10;  //remove the last integer
        }
        

       //validate
        if(n == sum) {
            return "Yes";
        }else {
            return "No";
        }
    }
}