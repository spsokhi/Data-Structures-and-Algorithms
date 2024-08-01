class Solution {
public:
    bool divideArray(vector<int>& nums) {
        map<int,int>mp;
        for(auto it:nums)mp[it]++;
        for(auto [n,cnt]:mp)
            if(cnt&1)return false;
        
        
        return true;
    }
};