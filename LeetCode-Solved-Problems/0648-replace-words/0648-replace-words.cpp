class Solution {
public:
    string replaceWords(vector<string>& dictionary, string sentence) {
        map<string, int>mp;
        for(string word:dictionary)
            mp[word]++;
        
        vector<string> words;
        string tmp = "";
        for(int i=0; i<sentence.size(); i++){
            if(sentence[i] == ' '){
                words.push_back(tmp);
                tmp="";
                continue;
            }
            tmp+=sentence[i];
        }
        if(tmp!="")words.push_back(tmp);
        // tmp = "";
        
        for(int j=0; j<words.size(); j++){
            tmp = "";
            for(int i=0; i<words[j].size(); i++){
                if(mp[tmp]){
                    words[j] = tmp;
                    break;
                }
                tmp+=words[j][i];
            }
        }
        
        string ans = "";
        for(int i=0; i<words.size(); i++){
            ans+=words[i];
            if(i < words.size()-1){
                ans+=' ';
            }
        }
        
        return ans;
    }
};