class Solution {
public:
    string reverseParentheses(string s) {
        stack<char>stk;
        for(char c:s){
            if(c==')'){
                vector<char>v;
                while(stk.top()!='('){
                    v.push_back(stk.top());
                    stk.pop();
                }
                stk.pop();
                for(auto it:v)stk.push(it);
            }
            else{
                stk.push(c);
            }
        }
        
        string ans="";
        while(!stk.empty()){
            char c = stk.top();
            stk.pop();
            ans.push_back(c);
        }
        
        reverse(ans.begin(), ans.end());
        return ans;
    }
};