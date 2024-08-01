class Solution {
public:
    vector<vector<int>> groupThePeople(vector<int>& groupSizes) {
        map<int,vector<int>>mp;
        for(int i=0;i<groupSizes.size();i++){
            mp[groupSizes[i]].push_back(i);
        }
        
        vector<vector<int>>ans;
        for(auto it:mp){
            int n=it.second.size();
            int indx=0;
            vector<int>tmp;
            int m = 0;
            while(indx<n){
                if(m==it.first){
                    m=0;
                    ans.push_back(tmp);
                    tmp.clear();
                }
                tmp.push_back(it.second[indx]);
                indx++;
                m++;
            }
            if(tmp.size())ans.push_back(tmp);
        }
        
        return ans;
    }
};