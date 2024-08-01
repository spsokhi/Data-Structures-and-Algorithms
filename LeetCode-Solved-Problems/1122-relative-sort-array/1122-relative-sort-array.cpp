class Solution {
public:
    vector<int> relativeSortArray(vector<int>& arr1, vector<int>& arr2) {
        map<int,int>mp;
        for(int e:arr1)mp[e]++;
        vector<int>ans;
        for(int el:arr2){
            while(mp[el]>0){
                ans.push_back(el);
                mp[el]--;
            }
        }
        for(auto it:mp){
            while(it.second){
                ans.push_back(it.first);
                it.second--;
            }
        }
        
        return ans;
    }
};