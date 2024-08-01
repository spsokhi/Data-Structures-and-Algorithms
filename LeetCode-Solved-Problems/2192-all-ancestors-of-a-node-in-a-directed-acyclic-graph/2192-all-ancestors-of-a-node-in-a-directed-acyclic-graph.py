class Solution:
    def getAncestors(self, n: int, edges: List[List[int]]) -> List[List[int]]:
        # topological sort
        indegrees = [0]*n
        
        adj_list = collections.defaultdict(list)
        
        for u, v in edges:
            adj_list[u].append(v)
            indegrees[v]+=1
            
        # find indegrees of 0
        q = collections.deque()
        
        for i in range(n):
            if indegrees[i]==0:
                q.append(i)
                
        ans = [set() for _ in range(n)]
        
        while len(q) > 0:
            now  = q.popleft()
            # ans[now] = list(sorted(ans))
            
            for child in adj_list[now]:
                ans[child].add(now)
                ans[child] |= ans[now]
                indegrees[child] -= 1
                
                if indegrees[child] == 0:
                    q.append(child)
        for i in range(n):
            ans[i] = list(sorted(ans[i]))
        return ans