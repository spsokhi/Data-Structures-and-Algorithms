class Solution {
public:
    string makeGood(string s) {
        
        stack<char>stk;
        
        for(char c:s){
            if(!stk.empty() and stk.top()!=c and lower(stk.top())==lower(c))
                stk.pop();
            else
                stk.push(c);
        }
        
        string ans="";
        while(!stk.empty()){
            ans.push_back(stk.top());
            stk.pop();
        }
        reverse(ans.begin(), ans.end());
        return ans;
    }
    
private:
    char lower(char c){
        if(c<'a'){
            return char(c+'a'-'A');
        }
        return c;
    }
};