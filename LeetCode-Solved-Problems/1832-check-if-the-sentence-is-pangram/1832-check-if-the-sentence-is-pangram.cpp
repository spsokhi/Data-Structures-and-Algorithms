class Solution {
public:
    bool checkIfPangram(string sentence) {
        vector<int>v(26);
        for(int i=0;i<sentence.size();i++)
            v[sentence[i]-'a']+=1;
        
        for(auto it:v)
            if(it==0)return false;
        
        return true;
    }
};