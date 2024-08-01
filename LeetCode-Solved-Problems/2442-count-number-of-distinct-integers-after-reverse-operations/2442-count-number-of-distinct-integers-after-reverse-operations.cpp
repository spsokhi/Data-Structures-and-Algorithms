class Solution {
public:
    int countDistinctIntegers(vector<int>& nums) {
        set<int>ans;
        for(auto num:nums){
            ans.insert(num);
            string s=to_string(num);
            reverse(s.begin(),s.end());
            int n=stoi(s);
            ans.insert(n);
        }
        
        return ans.size();
    }
};