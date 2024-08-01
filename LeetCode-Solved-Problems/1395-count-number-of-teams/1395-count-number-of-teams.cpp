class Solution {
public://neetcode... time:O{n}, space:O{1}
    int numTeams(vector<int>& rating) {
        int ans=0;
        
        for(int m=0; m < rating.size()-1; m++){
            int left_smaller=0, right_larger=0;
            for(int i=0; i<m; i++){
                if(rating[i]<rating[m])
                    left_smaller++;
            }
            for(int i=m+1; i<rating.size(); i++){
                if(rating[i]>rating[m])
                    right_larger++;
            }
            
            ans += (left_smaller * right_larger); // counting ascending order
            
            int left_larger = m - left_smaller;
            int right_smaller = rating.size() - m - 1 - right_larger;
            
            ans += (left_larger * right_smaller); // counting descending order
        }
        
        return ans;
    }
};