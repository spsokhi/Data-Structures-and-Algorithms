//{ Driver Code Starts
import java.io.*;
import java.util.*;

class IntArray {
    public static int[] input(BufferedReader br, int n) throws IOException {
        String[] s = br.readLine().trim().split(" ");
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = Integer.parseInt(s[i]);

        return a;
    }

    public static void print(int[] a) {
        for (int e : a) System.out.print(e + " ");
        System.out.println();
    }

    public static void print(ArrayList<Integer> a) {
        for (int e : a) System.out.print(e + " ");
        System.out.println();
    }
}

class IntMatrix {
    public static int[][] input(BufferedReader br, int n, int m) throws IOException {
        int[][] mat = new int[n][];

        for (int i = 0; i < n; i++) {
            String[] s = br.readLine().trim().split(" ");
            mat[i] = new int[s.length];
            for (int j = 0; j < s.length; j++) mat[i][j] = Integer.parseInt(s[j]);
        }

        return mat;
    }

    public static void print(int[][] m) {
        for (var a : m) {
            for (int e : a) System.out.print(e + " ");
            System.out.println();
        }
    }

    public static void print(ArrayList<ArrayList<Integer>> m) {
        for (var a : m) {
            for (int e : a) System.out.print(e + " ");
            System.out.println();
        }
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            int[] a = IntArray.input(br, 2);

            int[][] mat = IntMatrix.input(br, a[0], a[1]);

            Solution obj = new Solution();
            int res = obj.findShortestPath(mat);

            System.out.println(res);
        }
    }
}

// } Driver Code Ends


class Solution {
    public static int solve(int[][] mat, int i, int j,boolean[][] vis,int count)
    {
        
        if(i < 0 || i >= mat.length || j < 0 || j > mat[0].length || mat[i][j] == -1 || mat[i][j] == 0 || vis[i][j])
        {
            return Integer.MAX_VALUE;
        }
        if(j == mat[0].length - 1) return count;
        vis[i][j] = true;
        int n1 = solve(mat,i+1,j,vis,count+1);
        int n2 = solve(mat,i-1,j,vis,count+1);
        int n3 = solve(mat,i,j+1,vis,count+1);
        int n4 = solve(mat,i,j+1,vis,count+1);
        vis[i][j] = false;
        return Math.min(n1,Math.min(n2,Math.min(n3,n4)));
    }
    public static int findShortestPath(int[][] mat) {
        // code here
        for(int i = 0 ; i < mat.length ; i++)
        {
            for(int j = 0 ; j < mat[0].length ; j++)
            {
                if(i > 0 && mat[i-1][j] == 0)
                {
                    mat[i][j] = -1;
                }
                if(j > 0 && mat[i][j-1] == 0)
                {
                    mat[i][j] = -1;
                }
                if(i < mat.length - 1 && mat[i+1][j] == 0)
                {
                    mat[i][j] = -1;
                }
                if(j < mat[0].length - 1 && mat[i][j+1] == 0)
                {
                    mat[i][j] = -1;
                }
            }
        }
        int ans = Integer.MAX_VALUE;
        boolean[][] vis = new boolean[mat.length][mat[0].length];
        for(int i = 0 ; i < mat.length ; i++)
        {
            if(mat[i][0] == 1)
            ans = Math.min(ans,solve(mat,i,0,vis,0));
        }
        if(ans == Integer.MAX_VALUE) return -1;
        else return ans+1;
    }
}