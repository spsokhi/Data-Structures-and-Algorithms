class Solution {
public:
    string customSortString(string order, string s) {
        map<char,int>el;
        for(auto c:s)el[c]++;
        
        string ans="";
        for(char c:order){
            while(el[c]--)ans.push_back(c);
            el.erase(c);
        }
        
        for(auto it:el){
            while(it.second--)ans.push_back(it.first);
        }
        
        return ans;
    }
};