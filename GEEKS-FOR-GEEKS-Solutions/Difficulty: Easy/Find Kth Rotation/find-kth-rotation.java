//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    // Driver code
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        while (t-- > 0) {
            List<Integer> arr = new ArrayList<>();
            String input1 = sc.nextLine();
            Scanner ss1 = new Scanner(input1);
            while (ss1.hasNextInt()) {
                arr.add(ss1.nextInt());
            }
            Solution ob = new Solution();
            int res = ob.findKRotation(arr);
            System.out.println(res);
        }
    }
}

// } Driver Code Ends



class Solution {
   
    private int countRotations(List<Integer> arr, int low, int high) {
      
        if (high < low) return 0;

        if (high == low) return low;

       
        int mid = low + (high - low) / 2;

        if (mid < high && arr.get(mid + 1) < arr.get(mid)) return (mid + 1);

        if (mid > low && arr.get(mid) < arr.get(mid - 1)) return mid;

    
        if (arr.get(high) > arr.get(mid)) return countRotations(arr, low, mid - 1);

        return countRotations(arr, mid + 1, high);
    }

    public int findKRotation(List<Integer> arr) {
        int n = arr.size();
        return countRotations(arr, 0, n - 1);
    }
}
