class Solution {
public:// neetcode amazing solution
    int minimumDeletions(string s) {
        int a_count_right=0;
        for(char c:s)
            a_count_right += c=='a';
        
        int b_count_left = 0;
        int ans = INT_MAX;
        for(char c:s){
            if(c=='a') a_count_right --;
            
            ans = min(ans, a_count_right + b_count_left);
            
            if(c=='b') b_count_left ++;
        }
        
        return ans;
    }
};