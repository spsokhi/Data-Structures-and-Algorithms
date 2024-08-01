class Solution {
public:
    vector<int> frequencySort(vector<int>& nums) {
        map<int,int> mp;
        for(int num:nums)mp[num]++;
        
        map<int, priority_queue<int>> mp2;
        for(auto it:mp)
            mp2[it.second].push(it.first);
        
        vector<int> ans;
        for(auto it:mp2){
            while(it.second.size()){
                int n = it.first;
                int element = it.second.top();
                while(n--) ans.push_back(element);
                it.second.pop();
            }
        }
        
        return ans;
    }
};