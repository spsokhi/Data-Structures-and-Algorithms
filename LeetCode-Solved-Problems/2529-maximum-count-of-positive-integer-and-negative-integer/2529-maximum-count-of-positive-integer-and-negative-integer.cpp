class Solution {
public:
    int maximumCount(vector<int>& nums) {
        int pos=0,neg=0;
        for(auto n:nums){
            if(n==0)continue;
            n>0?pos++:neg++;
        }
        
        return max(pos,neg);
    }
};