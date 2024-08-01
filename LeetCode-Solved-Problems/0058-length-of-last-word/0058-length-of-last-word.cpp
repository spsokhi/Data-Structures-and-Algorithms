class Solution {
public:
    int lengthOfLastWord(string s) {
        int k=0,j;
        for(int i=s.size()-1;i>=0;i--){
            if(s[i]!=' '){
                j=i;
                break;
            }
        }
        for(;j>=0;j--){
                    if(s[j]==' ')break;
                    k++;
                }
        return k;
    }
};