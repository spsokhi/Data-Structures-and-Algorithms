class Solution {
public:
    vector<int> findingUsersActiveMinutes(vector<vector<int>>& logs, int k) {
        unordered_map<int,unordered_set<int>>mp;
        vector<int>ans(k);
        for(auto &el:logs)
            mp[el[0]].insert(el[1]);
        
        for(auto &it:mp)
            ans[it.second.size() -1]++;
        
        return ans;
    }
};