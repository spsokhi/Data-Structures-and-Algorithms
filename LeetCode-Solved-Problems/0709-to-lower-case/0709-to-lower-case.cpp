class Solution {
public:
    string toLowerCase(string s) {
        for(int i=0;i<s.length();i++){
            char ch = tolower(s[i]);
            s[i] = ch;
        }
        
        return s;
    }
};