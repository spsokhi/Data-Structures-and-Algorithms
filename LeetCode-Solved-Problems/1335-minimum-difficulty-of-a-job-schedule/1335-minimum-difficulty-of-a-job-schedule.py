class Solution:
    def minDifficulty(self, jobDifficulty: List[int], d: int) -> int:
        if len(jobDifficulty)<d:
            return -1
        
        cache = {}
        def dfs(i,d,cur_max):
            if i == len(jobDifficulty):
                return 0 if d==0 else float("inf")
            if d==0:
                return float("inf")
            
            if (i,d,cur_max) in cache:
                return cache[(i,d,cur_max)]
            
            cur_max = max(cur_max, jobDifficulty[i])
            
            res = min(
            dfs(i+1, d, cur_max),# continue the day
            cur_max + dfs(i+1, d-1, -1)# end the day
            )
            cache[(i,d,cur_max)] = res
            return res
        
        return dfs(0,d,-1)