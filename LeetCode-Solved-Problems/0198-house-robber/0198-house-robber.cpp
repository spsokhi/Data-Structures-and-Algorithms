class Solution {
public:
    int rob(vector<int>& nums) {
        int rob1=0, rob2=0;
        // [rob1, rob2, n, n+1, ...]
        for(int i=0;i<nums.size();i++){
            int tmp = max(rob1+nums[i],rob2);
            rob1 = rob2;
            rob2 = tmp;
        }
        
        return rob2;
    }
};