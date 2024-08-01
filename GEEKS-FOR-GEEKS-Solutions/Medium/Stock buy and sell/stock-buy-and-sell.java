//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

public class GFG {
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim()); //Inputting the testcases
        while(t-->0){
            int n = Integer.parseInt(br.readLine().trim());
            int A[] = new int[n];
            String inputLine[] = br.readLine().trim().split(" ");
            for(int i=0; i<n; i++){
                A[i] = Integer.parseInt(inputLine[i]);
            }
            int p = 0;
            for(int i=0; i<n-1; i++)
                p += Math.max(0,A[i+1]-A[i]);
                
            Solution obj = new Solution();
            ArrayList<ArrayList<Integer> > ans = obj.stockBuySell(A, n);
            if(ans.size()==0)
                System.out.print("No Profit");
            else{
                int c=0;
                for(int i=0; i<ans.size(); i++)
                    c += A[ans.get(i).get(1)]-A[ans.get(i).get(0)];
                
                if(c==p)
                    System.out.print(1);
                else
                    System.out.print(0);
            }System.out.println();
        }
    }
}
// } Driver Code Ends


//User function Template for Java
//Back-end complete function Template for Java

class Interval {
    int buy;
    int sell;
}

class Solution{
    //Function to find the days of buying and selling stock for max profit.
    ArrayList<ArrayList<Integer> > stockBuySell(int A[], int n) {
        
        ArrayList<ArrayList<Integer> > result = new ArrayList<ArrayList<Integer> >();
      //Prices must be given for at least two days else return the empty result.
        if(n==1){
            return result;
        }
        
        //Creating solution vector.
        ArrayList<Interval> sol = new ArrayList<Interval>();
        int i=0, cnt=0;
        //Traversing through given price array.
        while (i < n-1) {
            //Finding Local Minima. Note that the limit of loop is (n-2)
            //as we are comparing present element to the next element.
            while ((i < n-1) && (A[i+1] <= A[i])){
                i++;
            }
            //If we reach the end, we break loop as no further 
            //solution is possible.
            if (i == n-1){
                break;
            }
            Interval e = new Interval();
            //Storing the index of minima which gives the day of buying stock.
            e.buy = i++;
 
            //Finding Local Maxima. Note that the limit of loop is (n-1)
            //as we are comparing present element to previous element.
            while ((i < n) && (A[i] >= A[i-1]))
                i++;
 
            //Storing the index of maxima which gives the day of selling stock.
            e.sell = i-1;
            sol.add(e);
            //Incrementing count of buy/sell pairs.
            cnt++;
        }
        if(cnt==0){
            return result;
        } else {
            //Storing the buy/sell pairs in a list.
            for(int j=0; j<sol.size(); j++){
                result.add(new ArrayList<Integer>()); 
                result.get(j).add(0, sol.get(j).buy);
                result.get(j).add(1, sol.get(j).sell);
            }
        }
        //returning the result.
        return result;
    } 
    
}
