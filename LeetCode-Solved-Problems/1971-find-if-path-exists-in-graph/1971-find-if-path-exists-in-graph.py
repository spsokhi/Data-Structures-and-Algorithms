class Solution:
    def validPath(self, n: int, edges: List[List[int]], source: int, destination: int) -> bool:
        done = set()
        q = collections.deque()
        
        odj_list = collections.defaultdict(list)
        
        for u, v in edges:
            odj_list[u].append(v)
            odj_list[v].append(u)
            
        done.add(source)
        q.append(source)
        
        while len(q)>0:
            now = q.popleft()
            
            for v in odj_list[now]:
                if v not in done:
                    done.add(v)
                    q.append(v)
                    
        return destination in done
                    