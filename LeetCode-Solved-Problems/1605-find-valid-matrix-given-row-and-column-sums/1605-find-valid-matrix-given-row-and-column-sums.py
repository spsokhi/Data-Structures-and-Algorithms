class Solution:
    def restoreMatrix(self, rowSum: List[int], colSum: List[int]) -> List[List[int]]:
        n, m = len(rowSum), len(colSum)
        
        ans = [[0] * m for _ in range(n)]
        
        for r in range(n):
            ans[r][0] = rowSum[r]
            
        for c in range(m):
            cur_col_sum = 0
            for r in range(n):
                cur_col_sum += ans[r][c]
                
            r = 0
            while cur_col_sum > colSum[c]:
                diff = cur_col_sum - colSum[c]
                max_shift = min(diff, ans[r][c])
                
                ans[r][c] -= max_shift
                ans[r][c+1] += max_shift
                cur_col_sum -= max_shift
                
                r+= 1
                
        return ans