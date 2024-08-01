//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(in.readLine());
            String a[] = in.readLine().trim().split("\\s+");
            int arr[] = new int[N];
            for(int i = 0;i < N;i++)
                arr[i] = Integer.parseInt(a[i]);
            
            Solution ob = new Solution();
            List<Integer> ans = new ArrayList<Integer>();
            ans = ob.nextPermutation(N, arr);
            StringBuilder out = new StringBuilder();
            for(int i = 0;i < N;i++)
                out.append(ans.get(i) + " ");
            System.out.println(out);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    static List<Integer> nextPermutation(int n, int arr[]) {
        ArrayList<Integer> li = new ArrayList<>();
        int index = -1;

        // Find the rightmost element which is smaller than its next element
        for (int i = n - 2; i >= 0; i--) {
            if (arr[i] < arr[i + 1]) {
                index = i;
                break;
            }
        }

        // If no such element is found, reverse the array to get the smallest permutation
        if (index == -1) {
            Arrays.sort(arr);
        } else {
            // Find the smallest element on the right of the identified element that is larger than it
            for (int i = n - 1; i > index; i--) {
                if (arr[i] > arr[index]) {
                    int temp = arr[i];
                    arr[i] = arr[index];
                    arr[index] = temp;
                    break;
                }
            }
            // Reverse the subarray to the right of the identified index
            reverse(arr, index + 1, n - 1);
        }

        // Add the elements to the list
        for (int i = 0; i < n; i++) {
            li.add(arr[i]);
        }

        return li;
    }

    // Helper function to reverse a subarray
    static void reverse(int[] arr, int start, int end) {
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
}