class Solution {
public:
    string removeDuplicateLetters(string text) {
        vector<bool> seen(26, false);
        vector<int> freq(26, 0);

        for(char ch : text)
            freq[ch - 'a']++;

        stack<char> st;

        for(int i=0; i<text.size(); i++){
            char ch = text[i];

            freq[ch - 'a']--;
            if(seen[ch - 'a'])
                continue;

            while(st.size() != 0 && st.top() > ch && freq[st.top() - 'a'] > 0){
                seen[st.top() - 'a'] = false;
                st.pop();
            }
            seen[ch - 'a'] = true;
            st.push(ch);
        }

        string ans = "";
        while(st.size() != 0){
            ans += st.top();
            st.pop();
        }
        reverse(ans.begin(), ans.end());
        return ans;
    }
};