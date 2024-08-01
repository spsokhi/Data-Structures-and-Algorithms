class Solution {
public:
    vector<int> nextGreaterElement(vector<int>& nums1, vector<int>& nums2) {
        stack<int> stk;
        map<int,int>mp;
        
        for(int num:nums2){
            while(stk.size() and num > stk.top()){
                mp[stk.top()] = num;
                stk.pop();
            }
            
            stk.push(num);
        }
        
        vector<int> ans;
        for(int num: nums1){
            ans.push_back(mp.count(num)? mp[num]:-1);
        }
        
        return ans;
    }
};