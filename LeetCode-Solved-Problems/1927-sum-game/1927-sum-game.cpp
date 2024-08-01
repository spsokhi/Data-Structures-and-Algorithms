class Solution {
public:
    bool sumGame(string num) {
       int bal = 0 , balq = 0, n = num.size();
       for(int i=0;i<n;i++){
           if(num[i]=='?')
               balq += (i<n/2? 1:-1);
           else
               bal += (i<n/2? 1:-1)*(num[i]-'0');
       } 
        
       return balq&1 || bal+balq * 9/2 !=0; 
    }
};