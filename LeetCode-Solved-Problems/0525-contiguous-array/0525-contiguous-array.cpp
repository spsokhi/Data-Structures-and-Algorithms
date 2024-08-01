class Solution {
public:
    int findMaxLength(vector<int>& nums) {
        int zeros=0, ones=0;
        int ans =0 ;
        map<int, int> diff_indx;
        for(int i=0;i<nums.size();i++){
            nums[i]==0?zeros++:ones++;
            if(diff_indx.find(ones-zeros)==diff_indx.end())
                diff_indx[ones-zeros]  = i;
            
            if(ones==zeros)
                ans = ones+zeros;
            else{
                int indx = diff_indx[ones-zeros];
                ans = max(ans, i-indx);
            }
        }
        
        return ans;
    }
};