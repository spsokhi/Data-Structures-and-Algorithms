class Solution {
public:
    int maxProfit(vector<int>& prices) {
        int ans = 0;
        stack<int> stk;
        stk.push(prices[0]);
        for(int i=1; i<prices.size(); i++){
            if(!stk.empty() and prices[i]>stk.top()){
                ans = max(ans, prices[i] - stk.top());
                continue;
            }
            while(!stk.empty() and prices[i] < stk.top())
                stk.pop();
            stk.push(prices[i]);
        }
        
        return ans;
    }
};