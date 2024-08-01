class Solution {
public:
    int largestAltitude(vector<int>& gain) {
        int ans=0,cnt=0;
        for(auto num:gain){
            cnt+=num;
            ans = max(ans,cnt);
        }
        
        return ans;
    }
};