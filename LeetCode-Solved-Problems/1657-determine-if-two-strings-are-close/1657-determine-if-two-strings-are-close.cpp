class Solution {
public:
    bool closeStrings(string word1, string word2) {
        if(word1.size()!=word2.size())return false;
        
        vector<int>w1(26,0),w2(26,0);
        set<char>st1,st2;
        for(char c:word1){
            w1[c-'a']++;
            st1.insert(c);
        }
        for(char c:word2){
            w2[c-'a']++;
            st2.insert(c);
        }
        sort(w1.begin(),w1.end());
        sort(w2.begin(),w2.end());
        
        return w1==w2 && st1==st2;
    }
};