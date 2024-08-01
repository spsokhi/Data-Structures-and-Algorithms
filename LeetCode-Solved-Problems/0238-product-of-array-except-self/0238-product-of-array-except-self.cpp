class Solution {
public:
    vector<int> productExceptSelf(vector<int>& nums) {
        int prod=1, cntZero=count(nums.begin(),nums.end(),0);
        if(cntZero>1)
            return vector<int>(nums.size());
        
        for(auto el:nums)
            if(el)prod*=el;
        
        for(auto& it:nums){
            if(cntZero)it=it?0:prod;
            else it = prod/it;
        }
        
        return nums;
    }
};