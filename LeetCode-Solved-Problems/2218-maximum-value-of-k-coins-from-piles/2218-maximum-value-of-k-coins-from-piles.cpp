class Solution {
public:
    int dp[2001][2001]={0};
    int maxValueOfCoins(vector<vector<int>>& piles, int k) {
        return solve(0,piles,k);
    }
    int solve(int indx, vector<vector<int>>& piles, int k){
        if(indx>=piles.size())return 0;
        if(dp[indx][k]!=0)return dp[indx][k];
        int maxi=0,sum=0;
        // Either don't take that pile:
        maxi= max(maxi, solve(indx+1,piles,k));
        for(int i=0;i<piles[indx].size();i++){
            sum+=piles[indx][i];
            // or take some certain prefix from that pile, if we can take that much elements.
            if(k-(i+1)>=0)maxi = max(maxi, sum+solve(indx+1,piles,k-(i+1)));
        }
        
        return dp[indx][k]=maxi;
    }
};