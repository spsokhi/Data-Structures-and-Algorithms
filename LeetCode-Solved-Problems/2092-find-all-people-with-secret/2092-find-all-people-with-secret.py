class Solution:
    def findAllPeople(self, n: int, meetings: List[List[int]], firstPerson: int) -> List[int]:
        secrets = set([0, firstPerson]) # people with secret
        time_map = {} # time -> adj list meetings
        
        for src, dst, t in meetings:
            if t not in time_map:
                time_map[t] = defaultdict(list)
            # undirected graph
            time_map[t][src].append(dst)
            time_map[t][dst].append(src)
            
        def dfs(src, adj):
            if src in visit:
                return
            visit.add(src)
            secrets.add(src)
            for neighbor in adj[src]:
                dfs(neighbor, adj)
            
            
        for t in sorted(time_map.keys()):
            visit  = set()
            for src in time_map[t]:
                if src in secrets:
                    dfs(src, time_map[t])
                    
                    
        return list(secrets)
        