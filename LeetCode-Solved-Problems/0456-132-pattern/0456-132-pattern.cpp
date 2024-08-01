class Solution {
public:
    bool find132pattern(vector<int>& nums) {
        int s3 = INT_MIN;
        stack<int>stk;
        
        for(int i=nums.size()-1;i>=0;i--){
            if(nums[i]<s3)return true;
            else{
                while(!stk.empty() and nums[i]>stk.top()){
                    s3 = stk.top();
                    stk.pop();
                }
            }
            stk.push(nums[i]);
        }
        
        return false;
    }
};