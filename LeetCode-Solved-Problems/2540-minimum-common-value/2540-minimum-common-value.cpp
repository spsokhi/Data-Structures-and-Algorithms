class Solution {
public:
    int getCommon(vector<int>& nums1, vector<int>& nums2) {
        int f=0, s=0;
        while(f<nums1.size() and s<nums2.size()){
            if(nums1[f] == nums2[s])return nums1[f];
            
            if(nums1[f]<nums2[s])f++;
            else s++;
        }
        
        return -1;
    }
};