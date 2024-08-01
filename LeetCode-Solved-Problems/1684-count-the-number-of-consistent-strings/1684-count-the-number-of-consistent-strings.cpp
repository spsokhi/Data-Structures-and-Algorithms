class Solution {
public:
    int countConsistentStrings(string allowed, vector<string>& words) {
        int ans=0;
        map<char,int>mp;
        for(int i=0;i<allowed.size();i++)mp[allowed[i]]++;
        for(int i=0;i<words.size();i++){
            bool consistent = true;
            for(int j=0;j<words[i].size();j++){
                if(mp[words[i][j]]!=1){
                    consistent = false;
                    break;
                }
            }
            ans+= consistent?1:0;
        }
        
        
        return ans;
    }
};