class Solution {
public:
    string convertToTitle(int columnNumber) {
        string res="";
        while(columnNumber>0){
            columnNumber--;
            int m = columnNumber % 26;
            columnNumber /= 26;
            res+= 'A' + m;
        }
        reverse(res.begin(),res.end());
        return res;
    }
};