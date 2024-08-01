class Solution {
public:
    bool digitCount(string num) {
        map<int,int>mp;
        for(auto it:num){
            mp[it-'0']++;
        }
        
        for(int i=0;i<num.size();i++){
            if(mp[i] != (num[i]-'0') )return false;
        }
        
        return true;
    }
};