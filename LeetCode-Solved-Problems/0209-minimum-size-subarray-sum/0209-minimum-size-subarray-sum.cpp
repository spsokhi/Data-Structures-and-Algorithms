class Solution {
public:
    int minSubArrayLen(int target, vector<int>& nums) {
        // Sliding window approach
        int left = 0;
        int sum = 0;
        int ans = INT_MAX;
        
        for(int i=0;i<nums.size();i++){
            sum += nums[i];
            while(sum >= target){
                ans = min(ans, i-left+1);
                sum -= nums[left];
                left++;
            }
        }
        
        return ans>nums.size()? 0: ans;
    }
};