class Solution {
public:
    vector<int> plusOne(vector<int>& digits) {
        int n=digits.size(),pos=-1;
        if(digits[n-1]!=9){
            digits[n-1]++;
            return digits;
        }
        bool allNines=true;
        for(int i=n-1;i>=0;i--){
            if(digits[i]!=9){
                pos=i;
                allNines=false;
                break;
            }
        }
        if(allNines){
            for(int i=0;i<n;i++)digits[i]=0;
            digits.push_back(1);
            reverse(digits.begin(),digits.end());
        }
        else{
            digits[pos]++;
            for(int i=pos+1;i<n;i++)digits[i]=0;
        }
        
        return digits;
    }
};