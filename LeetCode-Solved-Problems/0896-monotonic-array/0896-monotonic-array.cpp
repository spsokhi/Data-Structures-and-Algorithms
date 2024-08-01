class Solution {
public:
    bool isMonotonic(vector<int>& nums) {
        return nums.size()==1 || incMonotonic(nums) || decMonotonic(nums);
    }
private:
    bool incMonotonic(vector<int>&nums){
        for(int i=1;i<nums.size();i++){
            if(nums[i]<nums[i-1])
                return false;
        }
        
        return true;
    }
    
    bool decMonotonic(vector<int>&nums){
        for(int i=1;i<nums.size();i++){
            if(nums[i]>nums[i-1])
                return false;
        }
        
        return true;
    }
};