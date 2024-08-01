class Solution {
public:
    string decodeMessage(string key, string message) {
        vector<char>map(26);
        int k=0;
        for(auto it:key){
            if(it!=' ' and !map[it-'a'])map[it-'a']=(k+'a'),k++;
        }
        
        for(int i=0;i<message.size();i++){
            if(message[i]!=' ')
                message[i]=map[message[i]-'a'];
        }
        
        return message;
    }
};