class Solution {
public:
    int numTrees(int n) {
        if(n<=1)return 1;
        
        int ans=0;
        for(int i=1;i<=n;i++){
            ans+= numTrees(i-1) * numTrees(n-i);
        }
        
        return ans;
    }
};

// Solution:
// https://leetcode.com/problems/unique-binary-search-trees/discuss/1565543/C%2B%2BPython-5-Easy-Solutions-w-Explanation-or-Optimization-from-Brute-Force-to-DP-to-Catalan-O(N)