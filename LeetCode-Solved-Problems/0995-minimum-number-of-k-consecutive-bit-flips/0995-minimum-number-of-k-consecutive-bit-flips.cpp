class Solution {
public:
    int minKBitFlips(vector<int>& nums, int k) {
        // neetcode
        deque<int> dq;
        int ans=0;
        
        for(int i=0; i<nums.size();i++){
            while(!dq.empty() and i > dq.front()+k-1)
                dq.pop_front();
            
            if((nums[i]+ dq.size())%2==0){
                if(i+k > nums.size()){
                    return -1;
                }
                
                ans++;
                dq.push_back(i);
            }
        }
        
        return ans;
    }
};