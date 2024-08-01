class Solution {
public:
    int findMiddleIndex(vector<int>& nums) {
        int n = nums.size();
        vector<int> pre(n), suff(n);
        pre[0] = nums[0];
        suff[n-1] = nums[n-1];
        for(int i=1;i<n; i++)
            pre[i] = pre[i-1] + nums[i];
        
        for(int i=n-2; i>=0; i--)
            suff[i] = suff[i+1] + nums[i];
        
        for(int i=0; i<n; i++)
            if(pre[i]==suff[i])
                return i;
        
        return -1;
    }
};