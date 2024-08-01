class Solution {
public:
    int minEatingSpeed(vector<int>& piles, int h) {
       int l = 1, r = *max_element(piles.begin(),piles.end());
        int ans = r;
        while(l<=r){
            int k = l + (r-l)/2;
            long hours = 0;
            for(int i = 0; i<piles.size();i++){
                hours += ceil((double) piles[i] / k);
            }
            if(hours<=h){
                ans = min(ans,k);
                r = k-1;
            }
            else{
                l = k+1;
            }
        }
        
        return ans;
    }
};

