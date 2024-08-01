class Solution {
public:
    vector<string> buildArray(vector<int>& target, int n) {
        int cnt = 1;
        vector<string>ans;
        for(int el:target){
            while(el!=cnt){
                ans.push_back("Push");
                ans.push_back("Pop");
                cnt++;
            }
            ans.push_back("Push");
            cnt++;
        }
        
        return ans;
    }
};