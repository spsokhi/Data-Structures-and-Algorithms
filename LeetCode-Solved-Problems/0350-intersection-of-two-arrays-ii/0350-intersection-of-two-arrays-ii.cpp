class Solution {
public:
    vector<int> intersect(vector<int>& nums1, vector<int>& nums2) {
        map<int,int>mp1, mp2;
        for(auto n:nums1)mp1[n]++;
        for(auto n:nums2)mp2[n]++;
        
        vector<int>ans;
        for(auto it:mp1){
            int n = min(mp1[it.first], mp2[it.first]);
            while(n--)
                ans.push_back(it.first);
        }
        
        return ans;
    }
};