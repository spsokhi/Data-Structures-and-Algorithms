class Solution {
public:
    string maximumOddBinaryNumber(string s) {
        int cntOnes=0;
        for(auto c:s)cntOnes+= c=='1';
        if(cntOnes==s.size())return s;
        string ans = "";
        for(int i=0;i<s.size();i++)ans.push_back('0');
        cntOnes--;
        ans[s.size()-1] = '1';
        int i=0;
        while(cntOnes--)
            ans[i++]='1';
        
        return ans;
    }
};