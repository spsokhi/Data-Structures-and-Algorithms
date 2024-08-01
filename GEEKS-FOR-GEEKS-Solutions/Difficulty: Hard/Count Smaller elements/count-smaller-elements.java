//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int arr[] = new int[s.length];
            for (int i = 0; i < s.length; i++) {
                arr[i] = Integer.parseInt(s[i]);
            }

            int[] ans = new Solution().constructLowerArray(arr);
            for (int i = 0; i < arr.length; i++) {
                System.out.print(ans[i] + " ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    int firstOccurrence(List<Integer> copy,int ele) {
        int left = 0;
        int right = copy.size() - 1 ;
        int mid = left + (right - left) / 2;
        
        while(left <= right) {
            if(copy.get(mid) == ele) {
                if(mid > 0 && copy.get(mid - 1) == ele)
                    right = mid - 1;
                else return mid;
            } else if(copy.get(mid) > ele) {
                right = mid - 1;
            } else left = mid + 1;
            
            mid = left + (right - left) / 2;
        }
        return -1;
    }
    int[] constructLowerArray(int[] arr) {
        List<Integer> copy = new ArrayList<>(arr.length);
        int[] ans = new int[arr.length];
        
        for(int ele : arr) 
            copy.add(ele);
        
        Collections.sort(copy);
        
        for(int i = 0; i < arr.length; i++) {
            int index = firstOccurrence(copy,arr[i]);
            ans[i] = index;
            copy.remove(index);
        }
        
        return ans;
    }
}