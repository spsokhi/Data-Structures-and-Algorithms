class Solution {
public:
    vector<int> findErrorNums(vector<int>& nums) {
        int size = nums.size();
        int total = (size*(size+1))/2;
        int sum = 0;
        int dup = 0;
        map<int,int>mp;
        for(int n:nums){
            sum+=n;
            if(dup)continue;
            mp[n]++;
            if(mp[n]>1)dup=n;
        }
        
        sum-=dup;
        return {dup,total-sum};
        
    }
};