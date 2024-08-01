class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        visit = set()
        ans = 0
        
        def dfs(i,j):
            if i<0 or j<0 or i >= len(grid) or j>=len(grid[0]) or grid[i][j]=="0":
                return
            if (i,j) in visit:
                return 
            
            visit.add((i,j))
            grid[i][j] = "0"
            
            dfs(i+1,j)
            dfs(i-1,j)
            dfs(i, j+1)
            dfs(i, j-1)
            
            
            
        
        for i in range(len(grid)):
            for j in range(len(grid[0])):
                if grid[i][j]=="1":
                    ans += 1
                    dfs(i,j)
                    
        return ans