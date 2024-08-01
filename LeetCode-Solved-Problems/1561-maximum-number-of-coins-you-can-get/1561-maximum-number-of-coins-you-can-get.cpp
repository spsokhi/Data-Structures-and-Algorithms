class Solution {
public:
    int maxCoins(vector<int>& piles) {
        sort(piles.begin(),piles.end(),greater<>());
        int ans=0, n = piles.size()/3;
        for(int i=1;i<2*n;i+=2)
            ans+=piles[i];
        
        return ans;
    }
};