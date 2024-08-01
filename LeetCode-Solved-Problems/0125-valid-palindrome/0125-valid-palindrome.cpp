class Solution {
public:
    bool isPalindrome(string s) {
        int l=0, r=s.size();
        while(l<r){
            while((s[l] > 'z' or s[l] < 'a') and (s[l] > 'Z' or s[l] < 'A') and (s[l]-'0'<0 or s[l]-'0'>9) and l<r)
                l++;
            while((s[r] > 'z' or s[r] < 'a') and (s[r] > 'Z' or s[r] < 'A') and (s[r]-'0'<0 or s[r]-'0'>9) and l<r)
                r--;
            
            if(l==r)return true;
            
            if(tolower(s[l]) != tolower(s[r]))
                return false;
            
            l++;
            r--;
        }
        
        return true;
    }
};