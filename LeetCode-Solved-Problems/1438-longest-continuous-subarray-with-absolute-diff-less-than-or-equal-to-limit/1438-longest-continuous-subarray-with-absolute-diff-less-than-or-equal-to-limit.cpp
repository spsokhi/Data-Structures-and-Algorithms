class Solution {
public:
    int longestSubarray(vector<int>& nums, int limit) {
        deque<int> max_q; // monotonic decreasing
        deque<int> min_q; // monotonic increasing
        int ans=0;
        int l=0;
        for(int r=0; r<nums.size(); r++){
            while(!max_q.empty() and nums[r] > max_q.back()){
                max_q.pop_back();
            }
            while(!min_q.empty() and nums[r] < min_q.back()){
                min_q.pop_back();
            }
            
            max_q.push_back(nums[r]);
            min_q.push_back(nums[r]);
            
            while(max_q.front()-min_q.front() > limit){
                if(nums[l]==max_q.front())
                    max_q.pop_front();
                if(nums[l]==min_q.front())
                    min_q.pop_front();
                
                l++;
            }
            
            ans = max(ans,(r-l+1));
        }
        
        return ans;
    }
};