class Solution {
public:
    bool checkXMatrix(vector<vector<int>>& grid) {
        int n = grid.size();
        set<pair<int,int>>st;
        for(int i=0 , j=n-1; i<n ;i++,j--){
            if(grid[i][i]==0 || grid[i][j]==0)return false;
            for(int k=0;k<n;k++){
               if(i != k and j != k){
                   if(grid[i][k]!=0)return false;
               }
            }
        }
        
        return true;
    }
};