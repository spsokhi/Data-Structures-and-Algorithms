class Solution {
public:
    long long maximumHappinessSum(vector<int>& happiness, int k) {
        sort(happiness.rbegin(), happiness.rend());
        long long ans=0;
        for(int i=0; i<happiness.size(); i++){
            if(happiness[i]-i > 0 and k>0){
                ans+=(happiness[i]-i);
                k--;
            }else break;
        }
        
        return ans;
    }
};