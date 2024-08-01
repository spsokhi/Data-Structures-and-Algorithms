class Solution {
public:
    string removeStars(string s) {
        int n=s.size();
        string ans="";
        stack<char>stck;
        for(int i=0;i<n;i++){
            if(s[i]=='*' and !stck.empty())stck.pop();
            else stck.push(s[i]);
        }
        
        while(!stck.empty()){
            ans+=stck.top();
            stck.pop();
        }
        
        reverse(ans.begin(),ans.end());
        return ans;
    }
};