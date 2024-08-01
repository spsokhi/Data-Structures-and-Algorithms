class Solution {
public:
    int minAddToMakeValid(string s) {
        int ans=0,cnt=0;
        for(auto ch:s){
            ch=='('?cnt++:cnt--;
            if(cnt<0){
                ans+=abs(cnt);
                cnt=0;
            }
        }
        
        ans+=cnt;
        
        
        return ans;
    }
};