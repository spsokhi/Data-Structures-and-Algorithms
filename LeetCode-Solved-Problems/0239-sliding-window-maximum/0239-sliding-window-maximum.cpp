class Solution {
public:
    vector<int> maxSlidingWindow(vector<int>& nums, int k) {
        // Sliding window , using deque, neetcode
        
        deque<int>dq; // that holds indeces
        vector<int>ans;
        
        int i=0,j=0;
        while(j<nums.size()){
            while(!dq.empty() and nums[j] > nums[dq.back()]){
                dq.pop_back();
            }
            
            dq.push_back(j);
            
            // if the index on left gets out of the window then remove it
            if(i>dq.front()){
                dq.pop_front();
            }
            
            if(j+1 >=k){
                ans.push_back(nums[dq.front()]);
                i++;
            }
            j++;
        }
        
        
        return ans;
    }
};