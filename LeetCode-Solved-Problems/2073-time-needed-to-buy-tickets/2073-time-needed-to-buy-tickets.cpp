class Solution {
public:
    int timeRequiredToBuy(vector<int>& tickets, int k) {
        int target = tickets[k];
        int ans = 0;
        for(int i=0;i<tickets.size();i++){
            if(tickets[i] >= target)
                ans+= i>k?target-1:target;
            else ans+=tickets[i];
        }
        
        
        return ans;
    }
};