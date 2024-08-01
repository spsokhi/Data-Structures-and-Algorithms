class Solution {
public:
    vector<int> majorityElement(vector<int>& nums) {
        map<int,int>mp;
        for(auto num:nums)mp[num]++;
        
        vector<int>ans;
        int target = nums.size()/3;
        
        for(auto it:mp){
            if(it.second>target)
                ans.push_back(it.first);
        }
        
        
        return ans;
    }
};