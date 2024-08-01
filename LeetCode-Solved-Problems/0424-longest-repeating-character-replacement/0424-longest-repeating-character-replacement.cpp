class Solution {
public:
    int characterReplacement(string s, int k) {
        // Sliding window >>>> neetcode
        vector<int>count(26);// Frequency array to calculate the apperances of characters
        int maxCnt=0;
        int ans=0;
        int i=0,j=0;
        
        while(j<s.size()){
            count[s[j]-'A']++;
            maxCnt = max(maxCnt, count[s[j]-'A']);
            // window size = j - i +1
            if((j-i+1-maxCnt) > k){
                count[s[i]-'A']--;
                i++;
            }
            
            ans= max(ans, j-i+1);
            j++;
        }
        
        return ans;
    }
};