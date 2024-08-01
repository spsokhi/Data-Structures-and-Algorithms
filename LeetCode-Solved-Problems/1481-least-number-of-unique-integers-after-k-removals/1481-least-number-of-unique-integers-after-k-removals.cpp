class Solution {
public:
    int findLeastNumOfUniqueInts(vector<int>& arr, int k) {
        map<int,int>mp;
        for(auto n:arr)mp[n]++;
        vector<int>v;
        for(auto it:mp)
            v.push_back(it.second);
        
        
        sort(v.begin(),v.end());
        int i=0;
        for(;i<v.size();i++){
            if(v[i]<=k)k-=v[i];
            else break;
        }
        
        return i==v.size()?0:v.size()-i;
    }
};