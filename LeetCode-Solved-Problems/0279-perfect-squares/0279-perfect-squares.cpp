class Solution {
public:
    int numSquares(int n) {
        vector<int> dp(n+1, n);
        dp[0]=0;
        
        for(int target=1; target<n+1; target++){
            for(int s = 1; s<target+1; s++){
                long long square = s*s;
                if(target - square < 0)
                    break;
                dp[target] = min(dp[target], 1 + dp[target-square]);
            }
        }
        
        return dp[n];
    }
};