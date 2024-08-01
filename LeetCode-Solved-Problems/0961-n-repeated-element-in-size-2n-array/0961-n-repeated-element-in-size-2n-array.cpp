class Solution {
public:
    int repeatedNTimes(vector<int>& nums) {
        map<int,int>mp;
        for(auto it:nums)mp[it]++;
        for(auto [num,cnt]:mp)
            if(cnt==mp.size()-1)return num;
        
        
        return 0;
    }
};