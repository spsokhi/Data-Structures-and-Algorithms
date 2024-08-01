class Solution {
public:
    int vowelStrings(vector<string>& words, int left, int right) {
        set<char>st({'a', 'e', 'i', 'o','u'});
        int ans=0;
        for(int i=left;i<=right;i++){
            if(st.find(words[i][0])!=st.end() and st.find(words[i][words[i].size()-1])!=st.end())
                ans++;
        }
        
        return ans;
    }
};