class Solution {
public:
    bool judgeCircle(string moves) {
        int i=0,j=0;
        for(int k=0;k<moves.size();k++){
            if(moves[k]=='R')j++;
            else if(moves[k]=='L')j--;
            else if(moves[k]=='U')i--;
            else i++;
        }
        
        return (i==0 and j==0);
            

    }
};