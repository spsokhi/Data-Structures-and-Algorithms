class Solution {
public:
    bool wordPattern(string pattern, string s) {
        vector<string>words;
        for(int i=0;i<s.size();i++){
            string t;
            while(s[i]!=' ' && i < s.size()){
                t+=s[i];
                i++;
            }
            words.push_back(t);
        }
        
        if(words.size()!=pattern.size())return false;
        
        unordered_map<string, char> map;
        set<char> count;
        for (int i = 0; i < pattern.size(); i++)
           {
              if (map.find(words[i]) == map.end() && count.find(pattern[i]) == count.end())
                 {
                  count.insert(pattern[i]);
                  map.emplace(words[i], pattern[i]);
                 }
              else if (map[words[i]] != pattern[i])
                {
                   return false;
                }
           } 
        
        return true;
        
//         map<char,string>mp;
//         for(int i=0;i<pattern.size();i++){
//             if(mp.find(pattern[i])==mp.end())mp[pattern[i]]=words[i];
//             else if(mp[pattern[i]]!=words[i])return false;
            
//         }
//         return true;
        
//         set<char>st1;
//         set<string>st2;
//         for(char c:s)st1.insert(c);
//         for(auto it:words)st2.insert(it);
        
//         return st1.size()==st2.size();

    }
};