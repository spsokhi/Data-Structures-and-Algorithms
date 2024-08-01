class Solution {
public:
    int myAtoi(string str) {
        
        int sign = 1, base = 0, i = 0;
    while (str[i] == ' ') { i++; }
    if (str[i] == '-' || str[i] == '+') {
        sign = 1 - 2 * (str[i++] == '-'); 
    }
    while (str[i] >= '0' && str[i] <= '9') {
        if (base >  INT_MAX / 10 || (base == INT_MAX / 10 && str[i] - '0' > 7)) {
            if (sign == 1) return INT_MAX;
            else return INT_MIN;
        }
        base  = 10 * base + (str[i++] - '0');
    }
    return base * sign;

        
        
//         int ans=0,mul=1,num,sign=0;
//         for(int i=s.size()-1;i>=0;i--){
//             if(s[i]==' ' or s[i]=='+' or s[i]=='-'){
//                 if(s[i]=='-')ans*=-1,sign=1;
                
//                 break;
//             }
            
//             if(s[i]>='0' and s[i]=<'9'){
//             num=s[i]-'0';
            
//             ans+= (num*mul);
//             mul*=10;
//             }
//         }
        
//         if(ans>INT_MAX)return INT_MAX;
//         if(ans<INT_MIN)return INT_MIN;
        
//         return ans;
    }
};