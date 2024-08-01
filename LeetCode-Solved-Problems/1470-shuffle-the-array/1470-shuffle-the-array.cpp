class Solution {
public:
    vector<int> shuffle(vector<int>& nums, int n) {
        vector<int>ans(2*n);
        int it=0;
        for(int i=0;i<=n-1;i++){
            ans[it]=nums[i];
            ans[it+1]=nums[i+n];
            it+=2;
        }
        
        return ans;
    }
};