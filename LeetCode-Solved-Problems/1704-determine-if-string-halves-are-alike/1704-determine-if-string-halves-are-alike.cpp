class Solution {
public:
    bool halvesAreAlike(string s) {
        set<char>st({'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'});
        int f=0,se=0;
        for(int i=0;i<s.size()/2;i++)if(st.find(s[i])!=st.end())f++;
        for(int i=s.size()/2;i<s.size();i++)if(st.find(s[i])!=st.end())se++;
        
        
        return f==se;
    }
};