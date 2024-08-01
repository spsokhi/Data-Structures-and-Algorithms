class Solution {
public:
    int minPairSum(vector<int>& nums) {
        sort(nums.begin(),nums.end());
        int l=0,r=nums.size()-1;
        int ans = INT_MIN;
        while(l<r){
            int tmp=nums[l++]+nums[r--];
            ans = max(ans,tmp);
        }
        
        return ans;
    }
};