class Solution {
public:
    bool checkString(string s) {
        int pos=-1;
        for(int i=0;i<s.length();i++){
            if(s[i]=='b'){
                pos=i;
                break;
            }
        }
        
        if(pos!=-1)
        for(int j=pos;j<s.length();j++){
                    if(s[j]=='a')return false;
                }
        
        return true;
    }
};