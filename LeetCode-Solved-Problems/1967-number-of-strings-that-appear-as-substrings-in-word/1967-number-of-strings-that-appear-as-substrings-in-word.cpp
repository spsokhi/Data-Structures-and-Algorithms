class Solution {
public:
    int numOfStrings(vector<string>& patterns, string word) {
        int ans=0;
        for(int i=0;i<patterns.size();i++){
           if(word.find(patterns[i])!=string::npos){
               ans++;
           } 
        }
        
        return ans;
    }
};

/*   string::npos
npos is a static member constant value with the greatest possible value for an element of type size_t.

This value, when used as the value for a len (or sublen) parameter in string's member functions, means "until the end of the string".

As a return value, it is usually used to indicate no matches.

This constant is defined with a value of -1, which because size_t is an unsigned integral type, it is the largest possible representable value for this type.

*/