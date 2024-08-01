class Solution {
public:
    vector<vector<int>> kClosest(vector<vector<int>>& points, int k) {
        vector<pair<long,int>>v;
        for(int i=0; i<points.size() ;i++){
            long distance = points[i][0]*points[i][0] + points[i][1]*points[i][1];
            v.push_back({distance, i});
        }
        sort(v.begin(), v.end());
        vector<vector<int>> ans;
        for(int i=0; i<k; i++){
            ans.push_back(points[v[i].second]);
        }
        
        return ans;
    }
};