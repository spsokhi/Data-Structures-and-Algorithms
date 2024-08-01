class Solution {
public:
    void moveZeroes(vector<int>& nums) {
        vector<int>ans;
        int zeros=0;
        for(int i=0;i<nums.size();i++){
            if(nums[i]==0)zeros++;
            else
                ans.push_back(nums[i]);
        }
        for(int i=0;i<zeros;i++)ans.push_back(0);
        for(int i=0;i<ans.size();i++)nums[i]=ans[i];
        
        
        
        
        // Code using erase function but it doesn't work I don't know why!
       /* int cnt=0;
       for(auto it=nums.begin();it!=nums.end();it++){
        if(*it == 0){
            cnt++;
            nums.erase(it);
        }
       }
       // cout<<cnt<<endl;
       for(int i=0;i<cnt;i++)nums.push_back(0);
       for(auto it:nums)cout<<it<<' ';*/
    }
};