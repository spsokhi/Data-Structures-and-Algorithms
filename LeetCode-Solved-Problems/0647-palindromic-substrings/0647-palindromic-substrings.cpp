class Solution {
public:
    int countSubstrings(string s) {
        int ans=0;
        for(int i=0;i<s.size();i++){
            int l=i,r=i; // for every index
            while(l>=0 and r<s.size() and s[l--]==s[r++]){
                ans++;
            }
            
            // for even index (every to chars)
            l = i;
            r = i+1;
            while(l>=0 and r<s.size() and s[l--]==s[r++]){
                ans++;
            }
        }
        
        return ans;
    }
};