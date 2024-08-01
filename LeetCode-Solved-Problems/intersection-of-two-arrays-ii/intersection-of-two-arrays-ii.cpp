class Solution {
public:
    vector<int> intersect(vector<int>& nums1, vector<int>& nums2) {
        vector<int>ans;
        map<int,int>mp1,mp2;
        unordered_set<int>st;
        for(int i=0;i<nums1.size();i++){
            mp1[nums1[i]]++;
            st.insert(nums1[i]);
        }
        for(int i=0;i<nums2.size();i++){
            mp2[nums2[i]]++;
            st.insert(nums2[i]);
        }
        
        for(auto it:st){
            if(mp1[it]>0 and mp2[it]>0){
                int rep=min(mp1[it],mp2[it]);
                while(rep--)ans.push_back(it);
            }
        }
        
        return ans;

    }
};