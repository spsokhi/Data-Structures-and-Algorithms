class Solution {
public:
    int largestRectangleArea(vector<int>& heights) {
        int maxArea = 0;
        stack<pair<int,int>> stk;
        
        for(int i=0;i<heights.size();i++){
            int start=i;
            
            while(!stk.empty() and stk.top().second > heights[i]){
                int index = stk.top().first;
                int width = i - index;
                int height = stk.top().second;
                stk.pop();
                
                maxArea = max(maxArea, height*width);
                start = index;
            }
            
            stk.push({start,heights[i]});
        }
        
        while(!stk.empty()){
            int width = heights.size() - stk.top().first;
            int height = stk.top().second;
            stk.pop();
                
            maxArea = max(maxArea, height*width);
        }
        
        return maxArea;
    }
};