class Solution {
public:
    int countKDifference(vector<int>& nums, int k) {
        unordered_map<int,int>mp;
        int ans=0;
        
        for(auto n:nums){
            ans+= mp[n+k]+mp[n-k];
            mp[n]++;
        }
        
        return ans;
    }
};