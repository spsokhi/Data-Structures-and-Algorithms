class Solution {
public:
    vector<vector<int>> findMatrix(vector<int>& nums) {
        map<int,int>mp;
        for(auto it:nums)mp[it]++;
        vector<vector<int>>ans;
        while(mp.size()){
            vector<int>v;
            for(auto it:mp)v.push_back(it.first);
            for(auto it:v)
                if(!--mp[it])
                    mp.erase(it);
            ans.push_back(v);
        }
        
        return ans;
    }
};