class Solution {
public:
    vector<int> findAnagrams(string s, string p) {
        // Sliding window
        if(s.size()<p.size())return {};
        
        vector<int> ans;
        
        vector<int>p_freq(26);
        for(char ch:p)p_freq[ch-'a']++;
        
        vector<int>s_freq(26);
        int i=0,j=0;
        
        while(j<s.size()){
            s_freq[s[j]-'a']++;
            
            if(j-i+1 == p.size()){
                if(vectorsAreEqual(p_freq,s_freq)){
                    ans.push_back(i);
                }
            }
            
            if(j-i+1 < p.size())j++;
            else{
                s_freq[s[i]-'a']--;
                i++;
                j++;
            }
        }
        
        return ans;
    }
    
private:
    bool vectorsAreEqual(vector<int>& v1, vector<int>& v2){
        for(int i=0;i<26;i++){
            if(v1[i] != v2[i])
                return false;
        }
        
        return true;
    }
    
};