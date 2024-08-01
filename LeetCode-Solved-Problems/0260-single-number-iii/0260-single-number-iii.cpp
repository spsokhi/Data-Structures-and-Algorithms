class Solution {
public:
    vector<int> singleNumber(vector<int>& nums) {
        // neetcode
        // Time: O(n), space: O(1)
        if(nums.size()==2)return nums;
        int Xor = 0;
        for(int num:nums)Xor^= num;
        
        int diff_bit = 1;
        while(!(Xor&diff_bit))
            diff_bit = diff_bit<<1;
        
        int a=0, b=0;
        for(int num:nums){
            if(diff_bit & num)
                a ^= num;
            else
                b ^= num;
        }
        
        return {a,b};
    }
};