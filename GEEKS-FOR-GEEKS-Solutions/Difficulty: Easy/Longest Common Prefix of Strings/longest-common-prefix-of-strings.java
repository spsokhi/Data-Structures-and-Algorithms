//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String arr[] = read.readLine().trim().split(" ");

            Solution ob = new Solution();
            System.out.println(ob.longestCommonPrefix(arr));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public String longestCommonPrefix(String strs[]) {
        // code here
        if (strs == null || strs.length == 0) {
            return "-1";
        }

        int minLength = Integer.MAX_VALUE;
        for (String str : strs) {
            minLength = Math.min(minLength, str.length());
        }

        StringBuilder prefix = new StringBuilder();

        for (int i = 0; i < minLength; i++) {
            HashMap<Character, Integer> charMap = new HashMap<>();
            for (String str : strs) {
                char currentChar = str.charAt(i);
                charMap.put(currentChar, charMap.getOrDefault(currentChar, 0) + 1);
            }

            if (charMap.size() == 1 && charMap.containsValue(strs.length)) {
                prefix.append(strs[0].charAt(i));
            } else {
                break;
            }
        }

        return prefix.length() == 0 ? "-1" : prefix.toString();
    
    
    }
}