class Solution:
    def longestIdealString(self, s: str, k: int) -> int:
        n = len(s)
        
        orda = ord('a')
        best = [0] * 26
        
        for c in s:
            current = ord(c) - orda
            
            start = max(0, current - k)
            end = min(25, current + k)
            
            best[current] = best[current] +1
            for i in range(start, end+1):
                if i != current:
                    best[current] = max(best[current], best[i]+1)
                
        return max(best)