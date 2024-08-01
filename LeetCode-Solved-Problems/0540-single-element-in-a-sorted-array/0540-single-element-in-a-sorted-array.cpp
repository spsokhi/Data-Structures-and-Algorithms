class Solution {
public:
    int singleNonDuplicate(vector<int>& nums) {
        if(nums.size()==1)return nums[0];
        for(int i=0;i<nums.size()-1;i+=2){
            if(nums[i]!=nums[i+1])
                return nums[i];
        }
        
        return nums[nums.size()-1];
    }
};