class Solution {
public:
    vector<int> sortJumbled(vector<int>& mapping, vector<int>& nums) {
        vector<pair<int,int>>v;
        for(int i=0; i<nums.size(); i++){
            int newNum = convert(nums[i], mapping);
            v.push_back({newNum, i});
        }
        sort(v.begin(), v.end());
        
        vector<int>ans;
        for(int i=0; i<v.size(); i++)
            ans.push_back(nums[v[i].second]);
        
        return ans;
    }
private:
    int convert(int num, vector<int>& mapping){
        if(num==0)return mapping[0];
        int res = 0;
        int cnt = 1;
        while(num>0){
            int digit = num%10;
            res += (mapping[digit] * cnt);
            cnt*=10;
            num/=10;
        }
        return res;
    }
};