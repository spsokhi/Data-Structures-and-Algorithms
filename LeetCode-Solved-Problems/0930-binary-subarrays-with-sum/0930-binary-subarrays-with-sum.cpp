class Solution {
public:
    int numSubarraysWithSum(vector<int>& nums, int goal) {
        return helper(goal, nums) - helper(goal-1, nums);
    }
    
private:
    // count # of subarrays with sum <= x
    int helper(int x, vector<int>& nums){
        if(x < 0) return 0;
        
        int ans =0 ;
        int l=0, curSum=0;
        for(int r=0; r<nums.size(); r++){
            curSum+=nums[r];
            while(curSum>x){
                curSum-=nums[l];
                l++;
            }
            ans += (r-l+1);
        }
        
        return ans;
        
    }
};