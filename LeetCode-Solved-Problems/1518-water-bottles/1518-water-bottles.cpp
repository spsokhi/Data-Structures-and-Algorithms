class Solution {
public:
    int numWaterBottles(int numBottles, int numExchange) {
        int ans = numBottles;
        int empty = numBottles;
        
        while( (empty / numExchange) > 0){
            ans += empty / numExchange;
            
            empty = (empty % numExchange)+(empty/numExchange);
        }
        
        return ans;
    }
};