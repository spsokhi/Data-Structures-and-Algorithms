class Solution {
public:
    long long largestPerimeter(vector<int>& nums) {
        sort(nums.begin(), nums.end());
        vector<long long> pre(nums.size(), 0);
        pre[0]=nums[0];
        for(int i=1;i<nums.size();i++)
            pre[i] = pre[i-1]+nums[i];
        
        for(int i=nums.size()-2; i>=0;i--)
            if(pre[i] > nums[i+1])return pre[i+1];
        
        return -1;
    }
};