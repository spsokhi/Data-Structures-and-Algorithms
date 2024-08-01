class Solution {
public:
    int maxIncreaseKeepingSkyline(vector<vector<int>>& grid) {
        int n=grid.size();
        vector<int>tmprow(n,0),tmpcol(n,0);
        
        for(int i=0;i<n;i++){
            int mxrow = *max_element(grid[i].begin(),grid[i].end());
            int mxcol = 0;
            for(int j=0;j<n;j++){
                mxcol = max(mxcol,grid[j][i]);
            }
            
            tmprow[i]=mxrow;
            tmpcol[i]=mxcol;
        }
        
        int ans=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                ans+=(min(tmprow[i],tmpcol[j])-grid[i][j]>0?min(tmprow[i],tmpcol[j])-grid[i][j]:0);
            }
        }
        
        return ans;
    }
};