class Solution {
public:
    string minRemoveToMakeValid(string s) {
        vector<char>v;
        int cnt=0;
        for(int i=0;i<s.size();i++){
            if(s[i]=='('){
                v.push_back(s[i]);
                cnt++;
            }
            else if(s[i]==')'){
                if(cnt>0){
                    cnt--;
                    v.push_back(s[i]);
                }
            }
            else{
                v.push_back(s[i]);
            }
        }
        
        
        if(cnt>0){
            for(int i=v.size()-1; i>=0; i--){
                if(v[i]=='(' and cnt>0){
                    v[i]='0';
                    cnt--;
                }
            }
        }
    
        string ans="";
        for(int i=0;i<v.size();i++)
            if(v[i]!='0')ans+=v[i];
        return ans;
    }
};