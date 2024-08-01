class Solution {
public:
    int minimumOneBitOperations(int n) {
        if (n <= 1)
            return n;
        int bit = 0;
        while ((1 << bit) <= n)
            bit++;
        return ((1 << bit) - 1) - minimumOneBitOperations(n - (1 << (bit-1)));
    }
};

// Explaination:
// https://leetcode.com/problems/minimum-one-bit-operations-to-make-integers-zero/discuss/877741/C%2B%2B-solution-with-explanation