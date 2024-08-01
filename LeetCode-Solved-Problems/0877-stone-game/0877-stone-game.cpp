class Solution {
public:
    bool stoneGame(vector<int>& piles) {
       sort(piles.begin(),piles.end(),greater<>());
        int a=0,b=0;
        for(int i=0;i<piles.size();i++){
            i&1? b+=piles[i] : a+=piles[i];
        }
        
        return a>b;
    }
};