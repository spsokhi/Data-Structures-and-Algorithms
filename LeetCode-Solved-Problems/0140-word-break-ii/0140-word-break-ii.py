class Solution:
    def wordBreak(self, s: str, wordDict: List[str]) -> List[str]:
        # Brute-force Backtracking 
        # Time: O(2^n)
        
        wordDict = set(wordDict)
        def backtrack(i):
            if i >= len(s):
                res.append(" ".join(cur))
                return 
            for j in range(i, len(s)):
                w = s[i:j+1]
                if w in wordDict:
                    cur.append(w)
                    backtrack(j+1)
                    cur.pop()
            
        cur = []
        res = []
        backtrack(0)
        return res