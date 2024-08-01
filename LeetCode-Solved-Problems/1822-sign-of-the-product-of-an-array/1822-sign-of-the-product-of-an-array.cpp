class Solution {
public:
    int arraySign(vector<int>& nums) {
        int minus = 0;
        for(auto it:nums){
            if(it<0)minus++;
            if(it==0)return 0;
        }
        
        return minus%2==0?1:-1;
        
    }
};