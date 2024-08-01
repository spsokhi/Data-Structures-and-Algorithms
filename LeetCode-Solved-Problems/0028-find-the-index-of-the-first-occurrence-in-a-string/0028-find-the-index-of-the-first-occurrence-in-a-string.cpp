class Solution {
public:
    int strStr(string haystack, string needle) {
        int n = needle.length(), m = haystack.length() ;
        
        for(int i=0;i<m;i++){
            if(i+n <= m){
                if(haystack.substr(i,n) == needle)
                    return i;
            }
        }
        
        return -1;
    }
};