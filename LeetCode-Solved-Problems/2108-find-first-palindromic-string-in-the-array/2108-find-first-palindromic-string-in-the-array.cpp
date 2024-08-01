class Solution {
public:
    bool isPalindrome(string test){
        int l=0,r=test.size()-1;
        while(l<r){
            if(test[r]!=test[l])return false;
            r--;
            l++;
        }
        
        return true;
    }
    
    string firstPalindrome(vector<string>& words) {
        for(int i=0;i<words.size();i++){
            if(isPalindrome(words[i]))return words[i];
        }
        
        return "";
    }
};