class Solution {
public:
    int diagonalSum(vector<vector<int>>& mat) {
        int n=mat.size(),sum=0;
        // summing the primary diagonal elements
        for(int i=0;i<mat.size();i++)sum+=mat[i][i];
        // summing the secondary diagonal elements
        int m=n-1;
        for(int i=0;i<mat.size();i++){
            sum+=mat[i][m];
            m--;
        }
        // if mat is odd remove the additional senter
        if(mat.size()&1)sum-=mat[n/2][n/2];
        
        return sum;
    }
};