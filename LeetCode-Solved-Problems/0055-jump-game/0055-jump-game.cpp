class Solution {
public:
    // I just iterate and update the maximal index that I can reach
    bool canJump(vector<int>& nums) {
        int reach = 0;
        int i = 0;
        for(;i<nums.size() && i<=reach; i++)
            reach = max(reach, i+nums[i]);
        
        return i==nums.size();
    }
};