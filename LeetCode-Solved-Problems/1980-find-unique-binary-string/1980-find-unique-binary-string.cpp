class Solution {
public:
    string findDifferentBinaryString(vector<string>& nums) {
        // We loop through the numbers and set the ith digit as the opposite of the ith digit in the ith    number.
        string ans;
        for(int i=0;i<nums.size();i++){
            ans+=nums[i][i]=='0'?"1":"0";
        }
        
        return ans;
    }
};