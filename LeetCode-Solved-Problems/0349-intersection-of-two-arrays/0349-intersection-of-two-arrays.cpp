class Solution {
public:
    vector<int> intersection(vector<int>& nums1, vector<int>& nums2) {
        vector<int>ans;
        unordered_set<int>st1,st2;
        for(int i=0;i<nums1.size();i++)st1.insert(nums1[i]);
        for(int i=0;i<nums2.size();i++)st2.insert(nums2[i]);
         
        if(st1.size()>st2.size()){
            for(auto it:st1){
                if(st2.find(it)!=st2.end())ans.push_back(it);
            }
        }
        else{
            for(auto it:st2){
                if(st1.find(it)!=st1.end())ans.push_back(it);
            }
        }
        return ans;
    }
};