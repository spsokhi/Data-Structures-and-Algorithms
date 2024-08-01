class Solution:
    def maximumGain(self, s: str, x: int, y: int) -> int:
        # neetcode amazing idea
        # O{n} time and space
        
        def remove_pairs(pair, score):
            nonlocal s
            res = 0
            stack = []
            
            for c in s:
                if c == pair[1] and stack and stack[-1] == pair[0]:
                    stack.pop()
                    res += score
                else:
                    stack.append(c)
            s = "".join(stack)
            return res
            
            
        ans = 0
        pair = "ab" if x>y else "ba"
        ans += remove_pairs(pair, max(x,y))
        ans += remove_pairs(pair[::-1], min(x,y))
        return ans