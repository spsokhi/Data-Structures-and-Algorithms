//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());

        while (T > 0) {
            int x = Integer.parseInt(br.readLine().trim());
            String[] input = br.readLine().trim().split(" ");
            int[] arr = Arrays.stream(input).mapToInt(Integer::parseInt).toArray();

            Solution solution = new Solution();
            System.out.println(solution.smallestSubWithSum(x, arr));

            T--;
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public static int smallestSubWithSum(int x, int[] arr) {
        int n = arr.length;
        int curr_sum = 0, min_len = n + 1;
        int start = 0, end = 0;

        while (end < n) {
            while (curr_sum <= x && end < n) curr_sum += arr[end++];

            while (curr_sum > x && start < n) {
                if (end - start < min_len) min_len = end - start;

                curr_sum -= arr[start++];
            }
        }

        if (min_len > n) return 0;
        return min_len;
    }
}