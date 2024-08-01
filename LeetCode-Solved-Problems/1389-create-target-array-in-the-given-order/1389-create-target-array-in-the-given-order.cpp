class Solution {
public:
    vector<int> createTargetArray(vector<int>& nums, vector<int>& index) {
       int n = nums.size();
       // first we make the correct index
        for(int i=0;i<n;i++){
            for(int j=0;j<i;j++){
                if(index[j]>=index[i])
                    index[j]++;
            }
        }
        
        
        // now set the numbers in thier indexes
        vector<int>ans(n);
        for(int i=0;i<n;i++)
            ans[index[i]]=nums[i];
        
        return ans;
    }
};