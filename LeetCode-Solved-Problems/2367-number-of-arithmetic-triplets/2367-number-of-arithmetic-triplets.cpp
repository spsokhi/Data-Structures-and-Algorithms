class Solution {
public:
    int arithmeticTriplets(vector<int>& nums, int diff) {
        int ans=0;
        set<int>st;
        for(auto it:nums)st.insert(it);
        for(int i=0;i<nums.size();i++){
            if(st.find(nums[i]+diff)!= st.end() and st.find(nums[i]+(diff*2))!= st.end() )ans++;
        }
        
        return ans;
    }
};