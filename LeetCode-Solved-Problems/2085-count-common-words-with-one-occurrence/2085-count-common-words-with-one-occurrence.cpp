class Solution {
public:
    int countWords(vector<string>& words1, vector<string>& words2) {
        map<string,int>mp1,mp2;
        for(auto it:words1)mp1[it]++;
        for(auto it:words2)mp2[it]++;
        
        int ans=0;
        for(auto it:mp1){
            if(it.second==1 and mp2[it.first]==1)ans++;
        }
        
        return ans;
    }
};