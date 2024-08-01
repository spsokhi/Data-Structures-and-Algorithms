class Solution {
public:
    vector<int> longestObstacleCourseAtEachPosition(vector<int>& obstacles) {
        vector<int>lis;
        for(int i=0;i<obstacles.size();i++){
            int x = obstacles[i];
            if(lis.empty() || lis[lis.size()-1]<=x){
                lis.push_back(x);
                obstacles[i] = lis.size();
            }
            else{
                int indx = upper_bound(lis.begin(),lis.end(),x)-lis.begin();
                lis[indx] = x;
                obstacles[i] = indx+1;
            }
        }
        
        
        return obstacles;
    }
};