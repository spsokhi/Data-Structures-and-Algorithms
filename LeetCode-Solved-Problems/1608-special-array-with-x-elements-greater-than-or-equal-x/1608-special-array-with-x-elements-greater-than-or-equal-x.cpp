class Solution {
public:
    int specialArray(vector<int>& nums) {
        // Time: O(n), Space: O(n)
        int n = nums.size();
        vector<int> count(n+1, 0);
        for(int num:nums){
            int indx = num < n? num:n;
            count[indx]++;
        }
        
        int total_right = 0;
        for(int i = n; i>=0; i--){
            total_right+=count[i];
            if(i == total_right)
                return total_right;
        }
        
        return -1;
    }
};