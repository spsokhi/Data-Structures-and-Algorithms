class Solution {
public:
    vector<int> sortArrayByParity(vector<int>& nums) {
        deque<int>dq;
        for(int num:nums)
            num&1?dq.push_back(num):dq.push_front(num);
        
        vector<int>ans;
        while(!dq.empty()){
            ans.push_back(dq.front());
            dq.pop_front();
        }
        
        return ans;
    }
};