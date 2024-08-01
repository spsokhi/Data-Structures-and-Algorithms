class Solution {
public:
    int minSteps(string s, string t) {
        unordered_map<char,int>mp;
        for(char c:s)mp[c]++;
        for(char c:t)mp[c]--;
        
        int ans = 0;
        for(auto it:mp){
            if(it.second<0)ans+=it.second;
        }
        
        return abs(ans);
    }
};