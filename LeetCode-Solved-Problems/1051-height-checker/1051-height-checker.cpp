class Solution {
public:
    int heightChecker(vector<int>& heights) {
        priority_queue<int>pq;
        for(int h:heights)pq.push(h);
        int ans=0;
        for(int i=heights.size()-1; i>=0; i--){
            if(heights[i]!=pq.top()){
                ans++;
            }
            pq.pop();
        }
        
        return ans;
    }
};