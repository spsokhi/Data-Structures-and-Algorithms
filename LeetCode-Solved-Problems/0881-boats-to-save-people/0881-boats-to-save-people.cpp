class Solution {
public:
    int numRescueBoats(vector<int>& people, int limit) {
        sort(begin(people), end(people));
        
        int ans=0;
        int left = 0, right = people.size()-1;
        
        while(left<=right){
            if(people[left] + people[right] <= limit){
                ans++;
                left++;
                right--;
            }else{
                ans++;
                right--;
            }
        }
        
        return ans;
    }
};