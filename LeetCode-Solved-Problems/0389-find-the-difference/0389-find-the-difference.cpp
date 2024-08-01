class Solution {
public:
    char findTheDifference(string s, string t) {
        vector<int>s_freq(26),t_freq(26);
        for(char ch:s)s_freq[ch-'a']++;
        for(char ch:t)t_freq[ch-'a']++;
        
        char ans = 'a';
        for(char ch:t){
            if(t_freq[ch-'a'] != s_freq[ch-'a']){
                ans = ch;
                break;
            }
                
        }
        
        
        return ans;
    }
};