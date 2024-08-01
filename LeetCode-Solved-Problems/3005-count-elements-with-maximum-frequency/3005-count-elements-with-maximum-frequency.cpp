class Solution {
public:
    int maxFrequencyElements(vector<int>& nums) {
        map<int,int>mp;
        for(auto n:nums)mp[n]++;
        int mx = 0;
        for(auto it:mp)
            mx = max(mx,it.second);
        int ans=0;
        for(auto it:mp)
            if(it.second == mx)ans+=mx;
        return ans;
    }
};