class Solution {
public:
    int pivotIndex(vector<int>& nums) {
        int n=nums.size();
        vector<int>presum(n),sufsum(n);
        presum[0]=nums[0];
        sufsum[n-1]=nums[n-1];
        for(int i=1;i<n;i++)presum[i]=nums[i]+presum[i-1];
        for(int i=n-2;i>=0;i--)sufsum[i]=nums[i]+sufsum[i+1];
        for(int i=0;i<n;i++){
            if(presum[i]==sufsum[i])return i;
        }
        
        return -1;
    }
};