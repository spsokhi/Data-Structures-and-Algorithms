class Solution {
public:
    int bagOfTokensScore(vector<int>& tokens, int power) {
        int l=0, r = tokens.size()-1;
        int res = 0, score =0 ;
        sort(begin(tokens), end(tokens));
        while(l<=r){
            if(tokens[l]<= power){
                power -= tokens[l++];
                score += 1;
                res = max(res,score);
            }else if(score>0){
                power += tokens[r--];
                score -= 1;
            }else break;
        }
        
        return res;
    }
};