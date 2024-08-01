class Solution {
public:
    int numSubarrayProductLessThanK(vector<int>& nums, int k) {
        int ans=0;
        int l=0;
        long product=1;
        for(int r=0; r<nums.size(); r++){
            product*= nums[r];
            while(l<=r and product>=k)
                product/=nums[l++];
            ans+= (r-l+1);
        }
        
        return ans;
        
    }
};