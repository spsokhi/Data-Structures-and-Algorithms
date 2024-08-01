class Solution {
public:
    // neetcode
    int findDuplicate(vector<int>& nums) {
        // hashmap solution is O(n) time and space (it fits btw but its not the approach we want)
        // to solve it in time: O(n) and space: O(1)
        // You have to deal with it as a linked list and to know Floyd's algorithm
        
        int slow=0, fast=0;
        while(true){
            slow = nums[slow];
            fast = nums[nums[fast]];
            if(slow==fast)break;
        }
        
        int slow2 = 0;
        while(true){
            slow = nums[slow];
            slow2 = nums[slow2];
            if(slow == slow2)break;
        }
        
        return slow;
    }
};