class Solution {
public:
    int minimumSum(int num) {
        vector<int>nums(4);
        for(int i=0;i<4;i++){
            nums[i]=num%10;
            num/=10;
        }
        sort(nums.begin(),nums.end());
        int n1,n2;
        n1=nums[0]*10+nums[2];
        n2=nums[1]*10+nums[3];
        
        int ans=n1+n2;
        return ans;
    }
};