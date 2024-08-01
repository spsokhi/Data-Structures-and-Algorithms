class Solution:
    def findFarmland(self, land: List[List[int]]) -> List[List[int]]:
        rows = len(land)
        cols = len(land[0])
        
        used = [[False] * cols for _ in range(rows)]
        ans = []
        
        for x in range(rows):
            for y in range(cols):
                if land[x][y]==1 and not used[x][y]:
                    sx, sy = x,y
                    ex, ey = sx, sy
                    
                    # go to the right as much as we can
                    while ey+1<cols and land[ex][ey+1]==1:
                        ey+=1
                    # go down as much as you can
                    while ex+1<rows and land[ex+1][ey]==1:
                        ex+=1
                        
                    ans.append((sx,sy,ex,ey))
                    
                    # now let's mark the cells we visit as true
                    for cx in range(sx, ex+1):
                        for cy in range(sy, ey+1):
                            used[cx][cy] = True
                            
        return ans
                        
                