//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            int n = Integer.parseInt(br.readLine().trim());
            char[] nuts = new char[n], bolts = new char[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                nuts[i] = (inputLine[i].charAt(0));
            }
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                bolts[i] = (inputLine[i].charAt(0));
            }

            new Solution().matchPairs(n, nuts, bolts);
            for (int i = 0; i < n; i++) {
                System.out.print(nuts[i] + " ");
            }
            System.out.println();
            for (int i = 0; i < n; i++) {
                System.out.print(bolts[i] + " ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public void matchPairs(int n, char nuts[], char bolts[]) {
        matchPairsUtil(nuts, bolts, 0, n - 1);
    }

    private void matchPairsUtil(char[] nuts, char[] bolts, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(nuts, low, high, bolts[high]);
            partition(bolts, low, high, nuts[pivotIndex]);
            matchPairsUtil(nuts, bolts, low, pivotIndex - 1);
            matchPairsUtil(nuts, bolts, pivotIndex + 1, high);
        }
    }

    private int partition(char[] array, int low, int high, char pivot) {
        int i = low;
        for (int j = low; j < high; j++) {
            if (array[j] < pivot) {
                swap(array, i, j);
                i++;
            } else if (array[j] == pivot) {
                swap(array, j, high);
                j--;
            }
        }
        swap(array, i, high);
        return i;
    }

    private void swap(char[] array, int i, int j) {
        char temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}