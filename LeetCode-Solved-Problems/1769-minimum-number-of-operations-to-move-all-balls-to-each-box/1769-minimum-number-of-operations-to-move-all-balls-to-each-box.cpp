class Solution {
public:
    vector<int> minOperations(string boxes) {
        // We first "move" balls from left to right, and track how many ops it takes for each box.
        // For that, we count how many balls we got so far in cnt, and accumulate it in ops.
        // Then, we do the same from right to left
        
        vector<int>ans(boxes.size());
        // from left to right
        for(int i=0,cnt=0,ops=0 ; i<boxes.size();i++){
            ans[i]+=ops;
            cnt+= boxes[i]=='1'?1:0;
            ops+=cnt;
        }
        // from right to left
        for(int i=boxes.size()-1,cnt=0,ops=0 ; i>=0;i--){
            ans[i]+=ops;
            cnt+= boxes[i]=='1'?1:0;
            ops+=cnt;
        }
        
        return ans;
    }
};