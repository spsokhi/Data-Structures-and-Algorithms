class Solution {
public:
    int countMatches(vector<vector<string>>& items, string ruleKey, string ruleValue) {
        int j = ruleKey=="type"? 0 : ruleKey=="color"?1:2;
        int ans=0;
        for(int i=0;i<items.size();i++){
            if(items[i][j] == ruleValue)ans++;
        }
        
        
        return ans;
    }
};