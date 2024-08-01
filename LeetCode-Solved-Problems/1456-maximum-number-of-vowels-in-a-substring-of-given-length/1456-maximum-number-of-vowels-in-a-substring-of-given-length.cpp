class Solution {
public:
    int maxVowels(string s, int k) {
        int curCount=0;
        int ans=0;
        
        bool vow[26]={false};
        vow[0] = vow[4] = vow[8] = vow[14] = vow[20] = true;
        
        for(int i=0;i<s.size();i++){
            if(i>=k and vow[s[i-k]-'a'])
                curCount--;
            
            if(vow[s[i]-'a'])
                curCount++;
            
            ans = max(ans,curCount);
        }
        
        
        return ans;
    }
};