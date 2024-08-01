class Solution {
public:
    vector<vector<string>> groupAnagrams(vector<string>& strs) {
        unordered_map<string,vector<string>>mp;
        for(auto str:strs){
            string t=str;
            sort(t.begin(),t.end());
            mp[t].push_back(str);
        }
        
        vector<vector<string>>ans;
        for(auto it:mp)
            ans.push_back(it.second);
        
        return ans;
    }
};