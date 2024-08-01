class Solution {
public:
    int numberOfSubarrays(vector<int>& nums, int k) {
        // 3-pointers sliding window
        int ans = 0;
        int odd = 0;
        int l=0, m=0;
        for(int r=0; r<nums.size(); r++){
            if(nums[r]&1)
                odd++;
            
            while(odd>k){
                if(nums[l]&1)
                    odd--;
                l++;
                m=l;
            }
            
            if(odd==k){
                while(!(nums[m]&1))
                    m++;
                ans+=(m-l+1);
            }
        }
        
        return ans;
    }
};