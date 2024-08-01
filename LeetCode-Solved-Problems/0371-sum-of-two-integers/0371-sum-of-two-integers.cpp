class Solution {
public:
    int getSum(int a, int b) {
        
        while(b != 0){
            int tmp = (a&b) << 1;
            a = a ^ b;
            b = tmp;
        }
        
        return a;
    }
};
/*
// we do XOR then AND 
// AND is our carry
// and we keep doing that untill our carry is = 0
 a = 9 , b = 11;
 a = 1001
 b = 1011
 a ^ b =         0010 ---> new a
 a & b = 1001
 (a & b) << 1 = 10010 ---> new b
 
 new a ^ new b =         10000 ---> new a
 (new a & new b) << 1 =  00100 ---> new b
 
 new a ^ new b = 10100 ---> answer = 20
 (new a & new b) << 1 = 00000 ---> carry = 0 so, we found the answer
 
*/