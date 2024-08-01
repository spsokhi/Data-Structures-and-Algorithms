class Solution {
public:
    int equalSubstring(string s, string t, int maxCost) {
        // Sliding window
        int curCost = 0;
        int l = 0;
        int ans = 0;
        
        for(int r=0; r< s.size(); r++){
            curCost += abs(s[r]-t[r]);
            
            while(curCost>maxCost)
                curCost-=abs(s[l]-t[l++]) ;
            
            ans = max(ans, r - l + 1);
        }
        
        return ans;
    }
};