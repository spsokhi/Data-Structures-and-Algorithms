//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class pair {
    long first, second;

    public pair(long first, long second) {
        this.first = first;
        this.second = second;
    }
}

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int x = Integer.parseInt(br.readLine().trim());
            String line = br.readLine();
            String[] tokens = line.split(" ");

            // Create an ArrayList to store the integers
            ArrayList<Long> array = new ArrayList<>();

            // Parse the tokens into integers and add to the array
            for (String token : tokens) {
                array.add(Long.parseLong(token));
            }

            int[] arr1 = new int[array.size()];
            int idx = 0;
            for (long i : array) arr1[idx++] = (int)i;

            String line2 = br.readLine();
            String[] tokens2 = line2.split(" ");

            // Create an ArrayList to store the integers
            ArrayList<Long> array2 = new ArrayList<>();

            // Parse the tokens into integers and add to the array
            for (String token2 : tokens2) {
                array2.add(Long.parseLong(token2));
            }

            int[] arr2 = new int[array2.size()];
            int idx2 = 0;
            for (long i : array2) arr2[idx2++] = (int)i;

            Solution obj = new Solution();
            pair[] answer = obj.allPairs(arr1, arr2, x);
            int sz = answer.length;

            if (sz == 0)
                System.out.println(-1);
            else {
                StringBuilder output = new StringBuilder();
                for (int i = 0; i < sz; i++) {
                    if (i < sz - 1)
                        output.append(answer[i].first + " " + answer[i].second + ", ");
                    else
                        output.append(answer[i].first + " " + answer[i].second);
                }
                System.out.println(output);
            }
        }
    }
}
// } Driver Code Ends


// User function Template for Java

/*
class pair  {
    long first, second;
    public pair(long first, long second)
    {
        this.first = first;
        this.second = second;
    }
}
*/

class Solution {
    public pair[] allPairs(int A[], int B[], int X) {
        // Your code goes here
        int N=A.length;
        int M=B.length;
        Arrays.sort(A);
        List<Integer> lst = new ArrayList<>();
        for(int i=0;i<M;i++){
            lst.add(B[i]);
        }
        List<pair> alt = new ArrayList<>();
        for(int i=0;i<N;i++){
            if(lst.contains(X-A[i])){
                alt.add(new pair(A[i], X-A[i]));
            }
        }
        return alt.toArray(new pair[alt.size()]);
    }
}