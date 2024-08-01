class Solution {
public:
    int minOperations(vector<int>& nums, int x) {
        // Sliding Window
        int sum=0, n=nums.size();
        for(int num:nums)sum+=num;
        
        int target = sum-x;
        int currSum=0, maxLength=0;
        int startIndx=0;
        bool found=false;
        
        for(int endIndx=0; endIndx<n; endIndx++){
            currSum+=nums[endIndx];
            while(startIndx<=endIndx && currSum>target){
                currSum-= nums[startIndx];
                startIndx++;
            }
            if(currSum==target){
                found = true;
                maxLength = max(maxLength, endIndx-startIndx+1);
            }
        }
        
        return found? n-maxLength : -1;
    }
};

// Solution:
// https://leetcode.com/problems/minimum-operations-to-reduce-x-to-zero/discuss/2136555/C%2B%2BPython-Simple-Solution-w-Explanation-or-Sliding-Window