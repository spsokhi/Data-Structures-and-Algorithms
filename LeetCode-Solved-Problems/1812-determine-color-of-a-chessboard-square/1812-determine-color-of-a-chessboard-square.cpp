class Solution {
public:
    bool squareIsWhite(string coordinates) {
        string startWhite = "aceg";
        bool white=false;
        char ch = coordinates[0];
        int indx = coordinates[1]-'0';
        for(int i=0;i<4;i++)
            if(ch==startWhite[i]){
                white=true;
                break;
            }
        
        if(white){
            return !(indx&1);
        }
        else
            return !(indx%2==0);
        
        //return (coordinates[0] + coordinates[1]) % 2 == 1; 
    }
};