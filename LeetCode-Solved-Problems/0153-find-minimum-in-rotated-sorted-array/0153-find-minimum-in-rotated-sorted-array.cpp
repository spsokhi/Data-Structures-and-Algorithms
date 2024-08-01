class Solution {
public:
    int findMin(vector<int>& nums) {
        // if you do it linear it'll be too slow so, you need to do it
        // in log(n) using binary search
        int l=0,r=nums.size()-1,mid;
        while(l<r){
            mid=(l+r)/2;
            if(nums[mid]>nums[nums.size()-1])
                l=mid+1;
            else
                r=mid;
        }
        
        return nums[l];
    }
};