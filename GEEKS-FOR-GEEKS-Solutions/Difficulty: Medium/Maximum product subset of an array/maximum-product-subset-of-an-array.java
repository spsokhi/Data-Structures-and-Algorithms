//{ Driver Code Starts
import java.util.*;

public class GFG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();

        while (tc-- > 0) {
            int n = sc.nextInt();
            List<Integer> list = new ArrayList<>();

            for (int i = 0; i < n; i++) list.add(sc.nextInt());

            Solution obj = new Solution();
            long ans = obj.findMaxProduct(list);

            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


class Solution {
    public long findMaxProduct(List<Integer> arr) {
        // Initialize variables
        long maxProduct = 1;
        long minNegative = Long.MAX_VALUE;
        int countNegative = 0;
        int countZero = 0;
        long productWithoutZero = 1;
        final int MOD = 1000000007;
        if (arr.size() == 1) {
            return arr.get(0);
        }

        for (int num : arr) {
            if (num == 0) {
                countZero++;
                continue;
            }
            if (num < 0) {
                countNegative++;
                minNegative = Math.min(minNegative, Math.abs((long)num));
            }
            productWithoutZero =(productWithoutZero* num)% MOD;
        }
        if (countZero == arr.size()) {
            return 0;
        }
        if (productWithoutZero > 0) {
            return productWithoutZero;
        }
        if (countNegative == 1 && countZero + countNegative == arr.size()) {
            return 0;
        }
        return productWithoutZero / (-minNegative);
    }
}