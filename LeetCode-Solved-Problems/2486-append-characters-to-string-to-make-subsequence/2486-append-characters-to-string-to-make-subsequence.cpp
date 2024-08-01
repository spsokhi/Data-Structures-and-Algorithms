class Solution {
public:
    int appendCharacters(string s, string t) {
        int is=0, it=0;
        int ans=0;
        while(is<s.size() and it<t.size()){
            if(s[is]==t[it]){
                it++;
            }
            is++;
        }
        ans = t.size() - it;
        return ans;
    }
};