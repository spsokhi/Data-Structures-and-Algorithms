//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            int[][] matrix = new int[n][m];
            for (int i = 0; i < n; i++) {
                String[] S = br.readLine().split(" ");
                for (int j = 0; j < m; j++) {
                    matrix[i][j] = Integer.parseInt(S[j]);
                }
            }
            Solution ob = new Solution();
            int[] ans = ob.FindExitPoint(n, m, matrix);
            for (int i = 0; i < ans.length; i++) System.out.print(ans[i] + " ");
            System.out.println();
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public int[] FindExitPoint(int n, int m, int[][] matrix) {
        // Initialize current position and direction
        int row = 0, col = 0;
        String direction = "right";

        // Movement directions
        HashMap<String, int[]> directions = new HashMap<>();
        directions.put("right", new int[]{0, 1});
        directions.put("down", new int[]{1, 0});
        directions.put("left", new int[]{0, -1});
        directions.put("up", new int[]{-1, 0});

        // Iterate until exit point is found
        while (row >= 0 && row < n && col >= 0 && col < m) {
            if (matrix[row][col] == 1) {
                // Change direction
                switch (direction) {
                    case "right":
                        direction = "down";
                        break;
                    case "down":
                        direction = "left";
                        break;
                    case "left":
                        direction = "up";
                        break;
                    case "up":
                        direction = "right";
                        break;
                }
                // Change the value of the current cell to 0
                matrix[row][col] = 0;
            }

            // Move in the current direction
            row += directions.get(direction)[0];
            col += directions.get(direction)[1];
        }

        // Return exit point
        int[] exitPoint = new int[]{row - directions.get(direction)[0], col - directions.get(direction)[1]};
        return exitPoint;
    }
}