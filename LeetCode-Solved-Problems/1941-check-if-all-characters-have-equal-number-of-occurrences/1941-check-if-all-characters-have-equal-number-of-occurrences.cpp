class Solution {
public:
    bool areOccurrencesEqual(string s) {
        map<char,int>mp;
        for(int i=0;i<s.size();i++)
            mp[s[i]]++;
        int ref = mp[s[0]];
        for(auto it:mp)
            if(it.second!=ref)return false;
        
        return true;
    }
};