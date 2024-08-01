class Solution {
public:
    int thirdMax(vector<int>& nums) {
        set<int>st;
        vector<int>v;
        for(auto it:nums)st.insert(it);
        for(auto it:st)v.push_back(it);
        sort(v.rbegin(),v.rend());
        if(v.size()>=3)
            return v[2];
        
        return v[0];
        
    }
};