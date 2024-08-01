class Solution {
public:
    string sortSentence(string s) {
        string ans="";
        map<int,string>mp;
        for(int i=0;i<s.size();i++){
            string temp="";
            int j=i;
            while(!isdigit(s[j])){
                temp+=s[j];
                j++;
            }
            i=j+1;
            mp[s[j]-'0']=temp;
        }
        
        for(auto it:mp){
            ans+=it.second;
            ans+=' ';
        }
        ans.pop_back();
        return ans;
    }
};