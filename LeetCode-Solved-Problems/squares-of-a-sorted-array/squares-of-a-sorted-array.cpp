class Solution {
public:
    vector<int> sortedSquares(vector<int>& nums) {
        for(int i=0;i<nums.size();i++){
            int tmp=nums[i];
            nums[i]=tmp*tmp;
        }
        
        sort(nums.begin(),nums.end());
        
        
        return nums;
    }
};