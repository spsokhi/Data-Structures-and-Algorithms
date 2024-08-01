class Solution {
public:
    vector<string> findRelativeRanks(vector<int>& score) {
        map<int,int> mp;
        vector<int> copy = score;
        sort(score.rbegin(), score.rend());
        for(int i=0; i<score.size();i++)
            mp[score[i]]=i;
        
        vector<string> ans;
        for(int i=0; i<copy.size(); i++){
            if(mp[copy[i]]==0)ans.push_back("Gold Medal");
            else if(mp[copy[i]]==1)ans.push_back("Silver Medal");
            else if(mp[copy[i]]==2)ans.push_back("Bronze Medal");
            else{
                string rank = to_string(mp[copy[i]]+1);
                ans.push_back(rank);
            }
        }
        
        return ans;
    }
};