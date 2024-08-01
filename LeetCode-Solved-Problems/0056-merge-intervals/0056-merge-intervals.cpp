class Solution {
public:
    vector<vector<int>> merge(vector<vector<int>>& intervals) {
        vector<vector<int>> ans;
        sort(begin(intervals), end(intervals));
        
        vector<int> newInterval = intervals[0];
        for(int i=1; i<intervals.size(); i++){
            if(newInterval[1] < intervals[i][0]){
                ans.push_back(newInterval);
                newInterval = intervals[i];
            }
            else{
                newInterval = {min(newInterval[0], intervals[i][0]), max(newInterval[1], intervals[i][1])};
            }
        }
        
        ans.push_back(newInterval);
        return ans;
    }
};