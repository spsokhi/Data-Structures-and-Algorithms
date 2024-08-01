class Solution {
    /*
    Put each number in its right place.
    For example:
    When we find 5, then swap it with A[4].
    At last, the first place where its number is not right, return the place + 1.
    */
public:
    int firstMissingPositive(vector<int>& nums) {
        int n=nums.size();
        for(int i=0;i<n;i++){
            while(nums[i]>0 and nums[i]<=n and nums[nums[i]-1]!=nums[i])
                swap(nums[i],nums[nums[i]-1]);
        } 
        
        for(int i=0;i<n;i++)
            if(nums[i]!=i+1)return i+1;
        
        return n+1;
    }
};