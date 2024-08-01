class Solution {
public:
    vector<int> findClosestElements(vector<int>& arr, int k, int x) {
        map<int,priority_queue<int, vector<int>, greater<int> >>mp;
        for(int n:arr){
            int diff = abs(n-x);
            mp[diff].push(n);
        }
        
        vector<int>ans;
        for(auto it:mp){
            while(!it.second.empty() and k>0){
                ans.push_back(it.second.top());
                it.second.pop();
                k--;
            }
        }
        
        sort(ans.begin(),ans.end());
        return ans;
    }
};