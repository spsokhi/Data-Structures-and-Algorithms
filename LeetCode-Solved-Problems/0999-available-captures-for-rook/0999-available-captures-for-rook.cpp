class Solution {
public:
    int numRookCaptures(vector<vector<char>>& board) {
        int indxi,indxj,ans=0;
        for(int i=0;i<board.size();i++){
            for(int j=0;j<board[i].size();j++){
                if(board[i][j]=='R'){
                    indxi=i;
                    indxj=j;
                    break;
                }
            }
        }
        
        // check down
        for(int i=indxj;i<8;i++){
            if(board[indxi][i]=='B')break;
            if(board[indxi][i]=='p'){
                ans++;
                break;
            }
        }
        // check on top
        for(int i=indxj;i>=0;i--){
            if(board[indxi][i]=='B')break;
            if(board[indxi][i]=='p'){
                ans++;
                break;
            }
        }
        // check right
        for(int i=indxi;i<8;i++){
            if(board[i][indxj]=='B')break;
            if(board[i][indxj]=='p'){
                ans++;
                break;
            }
        }
        // check left
        for(int i=indxi;i>=0;i--){
            if(board[i][indxj]=='B')break;
            if(board[i][indxj]=='p'){
                ans++;
                break;
            }
        }
        
        return ans;
    }
};

