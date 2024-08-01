class Solution {
public:
    int change(int amount, vector<int>& coins) {
        int dp[303][5005];
        memset(dp,-1, sizeof dp);
        return recursive(coins, 0, amount, dp);
    }
    
private:
    int recursive(vector<int>& coins, int indx,int remain, int dp[][5005]){
        if(remain==0)return 1;
        if(indx>=coins.size() or remain<0)return 0;
        if(dp[indx][remain] != -1)return dp[indx][remain];
        
        
        dp[indx][remain] = recursive(coins, indx, remain- coins[indx],dp)+ recursive(coins, indx+1, remain,dp);
        return dp[indx][remain];
    }
};