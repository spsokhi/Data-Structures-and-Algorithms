class Solution {
public:
    string addBinary(string a, string b) {
        int c=0;
        int la=a.length()-1,lb=b.length()-1;
        string res;
        while(la>=0 || lb>=0){
            int sum=c;
            if(la>=0)sum+=a[la--]-'0';
            if(lb>=0)sum+=b[lb--]-'0';
            
            c = sum>1?1:0;
            res+=to_string(sum%2);
        }
        
        if(c)res+=to_string(c);
        reverse(res.begin(),res.end());
        
        return res;
        
    }
};