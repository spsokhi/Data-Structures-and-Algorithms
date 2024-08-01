class Solution {
public:
    vector<int> twoOutOfThree(vector<int>& nums1, vector<int>& nums2, vector<int>& nums3) {
        set<int>st1,st2,st3;
        for(auto it:nums1)st1.insert(it);
        for(auto it:nums2)st2.insert(it);
        for(auto it:nums3)st3.insert(it);
        
        map<int,int>mp;
        for(auto it:st1)mp[it]++;
        for(auto it:st2)mp[it]++;
        for(auto it:st3)mp[it]++;
        
        vector<int>ans;
        for(auto it:mp)
            if(it.second>=2)ans.push_back(it.first);
        
        
        return ans;
    }
};