class Solution {
public:
    vector<int> findThePrefixCommonArray(vector<int>& A, vector<int>& B) {
       int cur = 0, n = A.size();
        vector<int> res(n), seen(n + 1);
        for (int i = 0; i < n; ++i) {
            if (++seen[A[i]] == 2) cur++;
            if (++seen[B[i]] == 2) cur++;
            res[i] = cur;
        }
        return res; 
    }
};