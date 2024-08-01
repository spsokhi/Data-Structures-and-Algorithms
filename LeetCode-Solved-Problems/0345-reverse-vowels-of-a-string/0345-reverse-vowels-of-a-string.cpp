class Solution {
public:
    bool isVowel(char c){
        return c=='a'||c=='e'||c=='i'||c=='o'||c=='u'||c=='A'||c=='E'||c=='I'||c=='O'||c=='U';
    }
    string reverseVowels(string s) {
        int l=0, r=s.size()-1;
        while(l<r){
            if(isVowel(s[l]) and isVowel(s[r])){
                swap(s[l],s[r]);
                r--;
                l++;
            }
            else if(isVowel(s[l]) and !isVowel(s[r]))r--;
            else if(!isVowel(s[l]) and isVowel(s[r]))l++;
            else l++,r--;
        }
        
        return s;
    }
};