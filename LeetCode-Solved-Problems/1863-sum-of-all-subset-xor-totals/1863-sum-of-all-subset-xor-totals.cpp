class Solution {
public:
    int subsetXORSum(vector<int>& nums) {
        // iterative, conseder every possible set of numbers
        // Time: O(2 ^ n)
        return dfs(0, 0, nums);
    }
private:
    int dfs(int i, int total, vector<int>& nums){
        if(i == nums.size())
            return total;
        
        return dfs(i+1, total ^ nums[i], nums) + dfs(i+1, total, nums);
    }
};