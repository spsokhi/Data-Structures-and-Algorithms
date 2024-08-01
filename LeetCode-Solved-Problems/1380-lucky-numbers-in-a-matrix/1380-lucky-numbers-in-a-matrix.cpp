class Solution {
public:
    vector<int> luckyNumbers (vector<vector<int>>& matrix) {
        int n = matrix.size();
        int m = matrix[0].size();
        set<int>mxset; // find max in each column
        for(int j=0;j<m;j++){
            int mx = 0;
            for(int i=0; i<n; i++){
                mx = max(mx, matrix[i][j]);
            }
            mxset.insert(mx);
        }
        
        vector<int>ans; // if a min in a row is also in mxset so it is a valid answer
        for(int i=0; i<matrix.size();i++){
            int mn = *min_element(matrix[i].begin(), matrix[i].end());
            if(mxset.find(mn) != mxset.end())
                ans.push_back(mn);
        }
        
        return ans;
    }
};