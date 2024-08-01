class Solution {
public:
    // The trickest part of this problem is to figure out that the solution is using STACK and the rest is easy
    int evalRPN(vector<string>& tokens) {
        stack<int>st;
        for(auto el:tokens){
            if(el!="+" and el!="-" and el!="*" and el!="/"){
                st.push(stoi(el));
                continue;
            }
            
            int tmp=st.top();
            st.pop();
            int tmp2=st.top();
            st.pop();
            
            int newEl = el == "+" ? tmp+tmp2 : el == "-" ? tmp2-tmp: el == "*" ? tmp*tmp2 : tmp2/tmp;
            st.push(newEl);
        }
        
        
        return st.top();
    }
};