class Solution {
public:
    vector<vector<int>> largestLocal(vector<vector<int>>& grid) {
        int n = grid.size();
        vector<vector<int>> ans(n-2, vector<int> (n-2));
        for(int i=1; i<n-1; i++){
            for(int j=1; j<n-1; j++){
                ans[i-1][j-1] = get_max(i, j, grid);
            }
        }

        return ans;
    }

private:
    int get_max(int i, int j, vector<vector<int>>& grid){
        int mx = 0;
        mx = max(grid[i][j], grid[i-1][j]);
        mx = max(mx, grid[i+1][j]);
        mx = max(mx, grid[i][j-1]);
        mx = max(mx, grid[i][j+1]);
        mx = max(mx, grid[i-1][j-1]);
        mx = max(mx, grid[i-1][j+1]);
        mx = max(mx, grid[i+1][j-1]);
        mx = max(mx, grid[i+1][j+1]);
        return mx;
    }
};