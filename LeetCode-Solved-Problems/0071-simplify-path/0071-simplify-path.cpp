class Solution {
public:
    string simplifyPath(string path) {
        stack<string>stck;
        string ans="";
        
        for(int i=0;i<path.size();i++){
            if(path[i]=='/')continue;
                
            string temp="";
            while(i<path.size() and path[i]!='/'){
                temp+=path[i];
                i++;
            }
            if(temp==".")continue;
            else if(temp==".."){
                if(!stck.empty())
                    stck.pop();
            }
            else stck.push(temp);
            
        }
        
        while(!stck.empty()){
            ans = "/"+stck.top()+ans;
            stck.pop();
        }
        
        if(ans.size()==0)return "/";
        
        return ans;
    }
};