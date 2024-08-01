class Solution:
    def minimumDeletions(self, s: str) -> int:
        cost = cnt_b = 0
        for ch in s:
            if ch == 'a' and cnt_b>0:
                cnt_b-=1
                cost+=1
            elif ch == 'b':
                cnt_b+=1
                
        return cost