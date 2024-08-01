class Solution {
public:
    bool canArrange(vector<int>& arr, int k) {
        unordered_map<int,int>mp;
        for(auto i:arr){
            int reminder = i%k;
            int complementOne = -1 * reminder;
            int complementTwo = reminder<0? -k-reminder : k-reminder;
            
            if(mp[complementOne]){
                mp[complementOne]--;
            }
            else if(mp[complementTwo]){
                mp[complementTwo]--;
            }
            else{
                mp[reminder]++;
            }
        }
        
        for(auto it:mp){
            if(it.second)return false;
        }
        return true;
    }
};