class Solution {
public:
    vector<string> sortPeople(vector<string>& names, vector<int>& heights) {
        vector<pair<int,string>>people;
        for(int i=0; i<names.size(); i++)
            people.push_back({heights[i], names[i]});
        
        sort(rbegin(people), rend(people));
        vector<string> ans;
        for(auto it:people)
            ans.push_back(it.second);
        
        
        return ans;
    }
};