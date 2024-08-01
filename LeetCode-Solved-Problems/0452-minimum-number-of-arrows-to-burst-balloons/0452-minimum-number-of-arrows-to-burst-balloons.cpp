class Solution {
public:
    int findMinArrowShots(vector<vector<int>>& points) {
        sort(begin(points), end(points));
        int ans=1;
        vector<int>newInterval = points[0];
        for(int i=1; i<points.size(); i++){
            if(points[i][0]<=newInterval[1]){
                newInterval = {max(newInterval[0], points[i][0]), min(newInterval[1], points[i][1])};
            } else{
                ans++;
                newInterval = points[i];
            }
        }
        
        return ans;
    }
};