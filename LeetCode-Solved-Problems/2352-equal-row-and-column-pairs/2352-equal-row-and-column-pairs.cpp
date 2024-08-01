class Solution {
public:
    int equalPairs(vector<vector<int>>& grid) {
        int ans=0,n=grid.size();
        map<vector<int>,int>mp;
        for(int j=0;j<n;j++){
            vector<int>col;
            for(int i=0;i<n;i++){
                col.push_back(grid[i][j]);
            }
            auto it = mp.find(col);
            if(it==mp.end())
                mp.emplace(col,1);
            else
                it->second++;
        }
        
        for(auto &row:grid)
            ans+=mp[row];
        
        return ans;
    }
};