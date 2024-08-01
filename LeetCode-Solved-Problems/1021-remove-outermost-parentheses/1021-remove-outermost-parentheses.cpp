class Solution {
public:
    string removeOuterParentheses(string s) {
        string ans;
        int cnt=0;
        for(auto c:s){
            if(c=='(' and cnt++ > 0)ans+='(';
            if(c==')' and cnt-- > 1)ans+=')';
        }
        return ans;
    }
};