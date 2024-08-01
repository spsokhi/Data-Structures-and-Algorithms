class Solution {
public:
    bool validateStackSequences(vector<int>& pushed, vector<int>& popped) {
        stack<int>stk;
        int p2=0;
        for(int i=0;i<pushed.size();i++){
            stk.push(pushed[i]);
            if(popped[p2]==stk.top()){
                stk.pop();
                p2++;
            }
            while(!stk.empty() and stk.top()==popped[p2]){
                stk.pop();
                p2++;
            }
        }
        
        for(int i=p2;i<popped.size(),!stk.empty();i++){
            if(popped[i]==stk.top()){
                stk.pop();
            }
            else{
                return false;
            }
        }
        
        return stk.empty();
    }
};