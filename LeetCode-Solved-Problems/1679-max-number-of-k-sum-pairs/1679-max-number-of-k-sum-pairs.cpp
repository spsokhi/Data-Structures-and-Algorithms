class Solution {
public:
    int maxOperations(vector<int>& nums, int k) {
        int l=0, r=nums.size()-1;
        int ans=0;
        sort(begin(nums),end(nums));
        while(l<r){
            if(nums[l]+nums[r]>k)r--;
            else if(nums[l]+nums[r]<k)l++;
            else if(nums[l]+nums[r]==k) {
                ans++;
                l++;
                r--;
            }
        }

        return ans;
    }
};