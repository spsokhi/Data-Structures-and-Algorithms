//{ Driver Code Starts
//Initial Template for Java



import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        while (tc-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int[] arr = new int[n];
            String[] inputLine = br.readLine().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            new Solution().pushZerosToEnd(arr, n);
            for (int i = 0; i < n; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends




//User function Template for Java

class Solution {
    void pushZerosToEnd(int[] arr, int n) {
        // code here
        
        // brute force
        // ArrayList<Integer> li=new ArrayList<Integer >();
        // for(int tmp:a){
        //     if(tmp!=0){
        //         li.add(tmp);
        //     }
        // }
        // for(int i=0;i<li.size();i++){
        //     a[i]=li.get(i);
        // }
        // for(int i= li.size();i<n;i++){
        //     a[i]=0;
        // }
        // return a;

        // optimal approach
        
        int left = 0;
        int right = 0;

        while (right < n) {
            if (arr[right] != 0) {
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
                left++;
            }
            right++;}
    }
}