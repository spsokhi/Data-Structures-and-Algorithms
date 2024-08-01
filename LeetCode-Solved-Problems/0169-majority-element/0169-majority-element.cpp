class Solution {
public:
    int majorityElement(vector<int>& nums) {
        map<int,int>mp;
        int half = nums.size() / 2;
        for(auto num:nums){
            mp[num]++;
            if(mp[num] > half) return num;
        }
        
        for(auto it:mp){
            if(it.second > half)
                return it.first;
        }
        
        return -1;
    }
};