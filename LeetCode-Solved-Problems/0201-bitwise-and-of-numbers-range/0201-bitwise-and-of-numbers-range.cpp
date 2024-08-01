class Solution {
public:
    int rangeBitwiseAnd(int left, int right) {
        if ((left == 0) || (right == 0)) return 0;
        
        // if there is a different amount of digits in binary - always will be zero
        if ((int)log2(left) != (int)log2(right)) return 0;
        
        int ans = left;
        for(long i=left;i<=right; i++)
            ans&=i;
        return ans;
    }
};