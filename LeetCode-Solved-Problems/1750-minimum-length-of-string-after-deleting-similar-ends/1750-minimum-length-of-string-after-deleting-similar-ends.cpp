class Solution {
public:
    int minimumLength(string s) {
        int l=0, r=s.size()-1;
        while(l<r and s[l] == s[r]){
            char tmp = s[l];
            while(s[l]==tmp and l<=r)l++;
            while(s[r]==tmp and r>=l)r--;
        }
        return r-l+1;
    }
};