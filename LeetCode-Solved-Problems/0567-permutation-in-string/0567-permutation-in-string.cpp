class Solution {
public:
    bool checkInclusion(string s1, string s2) {
        if(s2.size()<s1.size())return false;
        
        vector<int>s1_freq(26,0);
        for(char ch:s1)s1_freq[ch-'a']++;
        
        vector<int>s2_freq(26,0);
        int i=0,j=0;
        
        while(j<s2.size()){
            s2_freq[s2[j]-'a']++;
            
            if(j-i+1 == s1.size()){
                if(vectorsAreEqual(s1_freq,s2_freq))return true;
            }
            
            if(j-i+1 < s1.size()){
                j++;
            }
            else{
                s2_freq[s2[i]-'a']--;
                j++;
                i++;
            }
        }
        
        return false;
    }
private:
    bool vectorsAreEqual(vector<int>& v1, vector<int>& v2){
        for(int i=0;i<26;i++){
            if(v1[i]!=v2[i])return false;
        }
        return true;
    }    
};