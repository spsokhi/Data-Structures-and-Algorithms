class Solution {
public:
    string truncateSentence(string s, int k) {
        int cnt=0;
        string ans;
        for(auto c:s){
            if(c==' ')cnt++;
            if(cnt!=k)ans+=c;
            if(cnt==k)break;
        }
        
        return ans;
    }
};