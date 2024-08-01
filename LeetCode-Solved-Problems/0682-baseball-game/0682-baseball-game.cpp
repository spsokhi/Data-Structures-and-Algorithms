class Solution {
public:
    int calPoints(vector<string>& operations) {
        stack<int>st;
        for(int i=0;i<operations.size();i++){
            if(operations[i]=="+"){
                int tp = st.top();
                st.pop();
                int newRec = tp + st.top();
                st.push(tp);
                st.push(newRec);
            }
            else if(operations[i]=="D"){
                st.push(st.top()*2);
            }
            else if(operations[i]=="C"){
                st.pop();
            }
            else{
                st.push(stoi(operations[i]));
            }
        }
        
        int ans=0;
        while(!st.empty()){
            ans+=st.top();
            st.pop();
        }
        
        
        return ans;
    }
};