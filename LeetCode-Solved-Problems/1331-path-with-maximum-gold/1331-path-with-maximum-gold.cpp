class Solution {
public:
    int getMaximumGold(vector<vector<int>>& grid) {
        int ans = 0;
        for(int i=0; i<grid.size(); i++){
            for(int j=0; j<grid[0].size(); j++){
                ans = max(ans, dfs(i, j, grid));
            }
        }

        return ans;
    }

private:
    int dfs(int i, int j, vector<vector<int>>& grid){
        if(i<0 or i==grid.size())return 0;
        if(j<0 or j>=grid[0].size())return 0;
        if(grid[i][j]==0)return 0;

        int tmp = grid[i][j];
        grid[i][j] = 0; // to mark it as visited
        int path = 0;

        path = max(path, tmp + dfs(i+1, j, grid));// down
        path = max(path, tmp + dfs(i-1, j, grid));// up
        path = max(path, tmp + dfs(i, j+1, grid)); // right
        path = max(path, tmp + dfs(i, j-1, grid)); // left

        grid[i][j] = tmp;

        return path;

    }
};