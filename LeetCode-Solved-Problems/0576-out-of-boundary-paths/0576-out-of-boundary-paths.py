class Solution:
    def findPaths(self, m: int, n: int, maxMove: int, startRow: int, startColumn: int) -> int:
        rows, cols=m,n
        MOD = 10**9 +7
        cache={}
        
        def dfs(r,c,moves):
            if r<0 or r==rows or c<0 or c==cols:
                return 1 # valid path
            if moves==0:
                return 0
            if (r,c,moves) in cache:
                return cache[(r,c,moves)];
            
            cache[(r,c,moves)]=(
                dfs(r+1,c,moves-1)+dfs(r-1,c,moves-1)%MOD+
                 dfs(r,c+1,moves-1)+dfs(r,c-1,moves-1)%MOD
                )%MOD
            return cache[(r,c,moves)]
        
        return dfs(startRow, startColumn, maxMove)