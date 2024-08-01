class Solution {
public:
    vector<vector<int>> subsets(vector<int>& nums) {
        vector<vector<int>> ans;
        vector<int> tmp;
        dfs(0, nums, ans, tmp);
        return ans;
    }
    
private:
    void dfs(int i, vector<int>& nums, vector<vector<int>>& ans, vector<int>& tmp){
        ans.push_back(tmp);
        for(int j=i; j<nums.size(); j++){
            tmp.push_back(nums[j]);
            dfs(j+1, nums, ans, tmp);
            tmp.pop_back();
        }
    }
};