class Solution {
public:
    vector<vector<int>> imageSmoother(vector<vector<int>>& img) {
        m = img.size();
        n = img[0].size();
        vector<vector<int>> ans(m, vector<int>(n,0));
        
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                ans[i][j] = calcTheCell(img, i, j);
            }
        }
        
        return ans;
    }
    
private:
    int m,n;
    int calcTheCell(vector<vector<int>>& img, int i, int j){
        int sum = img[i][j];
        int divider = 1;
            if(i-1>=0)sum+=img[i-1][j] , divider++; // up
            if(i+1<=m-1)sum+=img[i+1][j] , divider++; // down
            if(j+1<=n-1)sum+=img[i][j+1] , divider++; // right
            if(j-1>=0)sum+=img[i][j-1] , divider++; // left
            if(i-1>=0 and j-1>=0)sum+=img[i-1][j-1] , divider++; // top-left
            if(i-1>=0 and j+1<=n-1)sum+=img[i-1][j+1] , divider++; // top-right
            if(i+1<=m-1 and j+1<=n-1)sum+=img[i+1][j+1] , divider++; // down-right
            if(i+1<=m-1 and j-1>=0)sum+=img[i+1][j-1] , divider++; // down-left
        return floor(sum/divider);
    }
};