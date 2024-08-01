class Solution:
    def generateParenthesis(self, n: int) -> List[str]:
        # recursive backtracking
        # number of left or right parens
        # only add open parenthesis if open < n
        # only add closing parenthesis if closed < open 
        # valid path if open == closed = n
        
        stack = []
        ans = []
        
        def backtrack(openN,closedN):
            if openN == closedN == n:
                ans.append(''.join(stack))
                return
            
            if openN < n:
                # adding open paren
                stack.append('(')
                backtrack(openN+1,closedN)
                stack.pop()
                
            if closedN < openN:
                # adding closing paren
                stack.append(')')
                backtrack(openN,closedN+1)
                stack.pop()
                
                
        backtrack(0,0)
        return ans