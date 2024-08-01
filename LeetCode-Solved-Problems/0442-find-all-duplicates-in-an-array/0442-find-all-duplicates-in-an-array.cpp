class Solution {
public:
    vector<int> findDuplicates(vector<int>& nums) {
        // I solve it using map (it passed) but we need to do it with O(1) space
        // neetcode: now let's solve it using time:O(n) and space:O(1);
        vector<int> ans;
        for(int i=0;i<nums.size();i++){
            int num = abs(nums[i]);
            if(nums[num - 1]<0)
                ans.push_back(num);
            else 
                nums[num-1] *= -1;
        }
        
        return ans;
    }
};