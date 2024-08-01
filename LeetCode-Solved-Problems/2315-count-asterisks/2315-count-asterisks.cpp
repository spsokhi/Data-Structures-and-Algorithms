class Solution {
public:
    int countAsterisks(string s) {
        int ans=0,as=0;
        
        for(int i=0;i<s.size();i++){
            if(s[i]=='|')as++;
            if(as%2==0 and s[i]=='*')ans++;
        }
        
        return ans;
    }
};