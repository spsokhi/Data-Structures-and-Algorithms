class Solution:
    def numSteps(self, s: str) -> int:
        def addOne(s):
            i = len(s) -1
            s = list(s)
            while i >= 0 and s[i] == "1":
                s[i] = "0"
                i -= 1
            
            if i == -1:
                s = ["1"] + s
            else:
                s[i] = "1"
            
            return "".join(s)
        
        ans = 0
        while s != "1":
            if s[-1] == "0":
                s = s[:-1]
            else:
                s = addOne(s)
            ans += 1
            
        return ans