class Solution {
public:
    string intToRoman(int num) {
        string ans;
        string roman[] = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        int nums[] = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
        
        for(int i=0;num!=0;i++){
            while(num>=nums[i]){
                num-=nums[i];
                ans+=roman[i];
            }
        }
        
        return ans;
    }
};