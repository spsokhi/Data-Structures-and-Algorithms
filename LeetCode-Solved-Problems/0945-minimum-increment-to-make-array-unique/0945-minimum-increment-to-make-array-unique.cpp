class Solution {
public:
    int minIncrementForUnique(vector<int>& nums) {
        map<int,int>mp;
        for(int n:nums)mp[n]++;
        int ans=0;
        for(auto it:mp){
            if(it.second > 1){
                ans += it.second-1;
                mp[it.first+1] += it.second-1;
                it.second=1;
            }
        }
        
        return ans;
    }
};