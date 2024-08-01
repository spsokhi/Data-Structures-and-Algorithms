class Solution {
public:
    const vector<string> pad = {
        "", "", "abc", "def", "ghi", "jkl",
        "mno", "pqrs", "tuv", "wxyz"
    };
    
    vector<string> letterCombinations(string digits) {
        if(digits.size()==0)return {};
        vector<string>ans;
        ans.push_back("");
        
        for(auto digit:digits){
            vector<string>tmp;
            for(auto c:pad[digit-'0']){
                for(auto s:ans){
                    tmp.push_back(s+c);
                }
            }
            
            ans.swap(tmp);
        }
        
        
        return ans;
    }
};