class Solution {
public:
    int minDifference(vector<int>& nums) {
        if(nums.size()<=4)return 0;
        
        sort(nums.begin(), nums.end());
        int mn = INT_MAX;
        int c = 3;
        for(int i=0; i<=3; i++){
            mn = min(nums[nums.size() - c - 1] - nums[i], mn);
            c--;
        }
        
        return mn;
    }
};