class Solution {
public:
    int maxSubarrayLength(vector<int>& nums, int k) {
        // Sliding window
        int ans=0;
        map<int,int>mp;
        int l=0;
        for(int r=0; r<nums.size(); r++){
            mp[nums[r]]++;
            while(mp[nums[r]] > k){
                mp[nums[l++]]--;
            }
            
            ans = max(ans, r-l+1);
        }
        
        return ans;
    }
};