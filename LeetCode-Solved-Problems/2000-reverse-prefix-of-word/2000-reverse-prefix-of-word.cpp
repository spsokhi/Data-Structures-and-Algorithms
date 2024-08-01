class Solution {
public:
    string reversePrefix(string word, char ch) {
        int k=0;
        for(int i=0;i<word.size();i++){
            if(word[i]==ch){
                k=i;
                break;
            }
        }
        if(k!=0)
        reverse(word.begin(),word.begin()+k+1);
        return word;
    }
};