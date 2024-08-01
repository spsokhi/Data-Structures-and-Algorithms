class Solution {
public:
    int minOperations(vector<int>& nums, int k) {
        int x = 0;
        for(int c:nums)
            x ^= c; // get the output of XORing all elements of the array
        
        x ^= k; // XORing the output with k
            
        int count = 0;
        
        // now if there is a difference(bit == 1) so, we neet to change this bit to make the output equal to k , because if the output was equal to k so we need to change nothing
        while(x>0){
            count += x%2;
            x/=2;
        }
        
        return count;
    }
};