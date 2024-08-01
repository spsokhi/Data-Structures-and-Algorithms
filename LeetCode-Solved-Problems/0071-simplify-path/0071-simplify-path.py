class Solution:
    def simplifyPath(self, path: str) -> str:
        files = path.split('/')
        stack = []
        for file in files:
            if file == '' or file == '.':
                continue
            if file == '..':
                if len(stack)>0:
                    stack.pop()
            else:
                stack.append(file)
        return '/'+'/'.join(stack)