class Solution {
public:
    bool searchMatrix(vector<vector<int>>& matrix, int target) {
        
        int l=0,r=matrix.size()*matrix[0].size()-1;
        while(l<=r){
            int mid = l + (r-l)/2;
            int row = mid / matrix[0].size();
            int col = mid % matrix[0].size();
            if(matrix[row][col]==target)return true;
            else if(matrix[row][col]<target)l=mid+1;
            else{
                r=mid-1;
            }
        }
        
        return false;
    }
};