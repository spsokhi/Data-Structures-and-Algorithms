Cubic solution:
int equalPairs(vector<vector<int>>& grid) {
int ans=0, n = grid.size();
for(int i=0;i<n;i++){
for(int j=0;j<grid[i].size();j++){
int k=0;
while(k<n and grid[i][k]==grid[k][j])
k++;
ans+= k==n;
}
}
return ans;
}
-->>> Three map solution: