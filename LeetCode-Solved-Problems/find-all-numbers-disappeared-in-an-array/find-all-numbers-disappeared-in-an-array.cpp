class Solution {
public:
    vector<int> findDisappearedNumbers(vector<int>& nums) {
        vector<int>ans;
        set<int>st;
        for(auto it:nums)st.insert(it);
        for(int i=1;i<=nums.size();i++){
            if(st.find(i)!=st.end())continue;
            else ans.push_back(i);
            
        }
        
        sort(ans.begin(),ans.end());
        return ans;
    }
};