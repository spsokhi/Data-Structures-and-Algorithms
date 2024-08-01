class Solution {
public:
    bool isItPossible(string word1, string word2) {
        unordered_map<char,int>mp1,mp2;
        for(char c:word1)mp1[c]++;
        for(char c:word2)mp2[c]++;
        
        for(int i=0;i<26;i++){
            for(int j=0;j<26;j++){
                char c1=i+'a',c2=j+'a';
                if(mp1.count(c1) and mp2.count(c2)){
                    if(--mp1[c1]==0)mp1.erase(c1);
                    if(--mp2[c2]==0)mp2.erase(c2);
                    
                    mp1[c2]++;
                    mp2[c1]++;
                    
                    if(mp1.size() == mp2.size())
                        return true;
                    
                    
                    if(--mp1[c2]==0)mp1.erase(c2);
                    if(--mp2[c1]==0)mp2.erase(c1);
                    
                    mp1[c1]++;
                    mp2[c2]++;
                    
                }
            }
        }
        
        return false;
    }
};