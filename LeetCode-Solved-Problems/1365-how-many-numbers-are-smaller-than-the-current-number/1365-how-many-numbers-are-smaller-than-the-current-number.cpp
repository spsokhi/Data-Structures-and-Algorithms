class Solution {
public:
    vector<int> smallerNumbersThanCurrent(vector<int>& nums) {
    map<int,int>mp;
    int n=nums.size();
    vector<int>v;
    for(int i=0;i<n;i++){
        mp[nums[i]]++;
    }
    for(int i=0;i<n;i++){
        int ans=0;
        for(auto it:mp){
            if(it.first==nums[i])break;
            ans+=it.second;
        }
        v.push_back(ans);
    }
    return v;
}
};