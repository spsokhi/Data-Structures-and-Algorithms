class Solution:
    def maximumSafenessFactor(self, grid: List[List[int]]) -> int:
        # its a combination of a leetcode medium and a leetcode hard
        # time: O(n^2 * log n), space: O(n^2)
        n = len(grid)

        def in_bound(r,c):
            return min(r,c)>=0 and max(r,c)<n

        # calculating the distances for every cell from its nearest thief
        # using: MUlti-source BFS
        def precompute():
            q = deque()
            min_dist = {}
            for r in range(n):
                for c in range(n):
                    if grid[r][c]==1:
                        q.append([r,c,0]) 
                        min_dist[(r,c)] = 0
            while q:
                r, c, dist = q.popleft()
                nei = [[r+1, c], [r-1, c], [r, c+1], [r, c-1]]
                for r2, c2 in nei:
                    if in_bound(r2, c2) and (r2,c2) not in min_dist:
                        min_dist[(r2, c2)] = dist+1
                        q.append([r2, c2, dist+1])
            return min_dist

        min_dist = precompute()
        maxHeap = [(-min_dist[(0,0)], 0, 0)] # (dist, r, c)
        visit = set()
        visit.add((0,0))

        while maxHeap:
            dist, r, c = heapq.heappop(maxHeap)
            dist = -dist

            if (r,c) == (n-1, n-1):
                return dist # answer

            nei = [[r+1, c], [r-1, c], [r, c+1], [r, c-1]]
            for r2, c2 in nei:
                if in_bound(r2, c2) and (r2,c2) not in visit:
                    visit.add((r2, c2))
                    new_dist = min(dist, min_dist[(r2, c2)]) # min between last dist and my dist(nei)
                    heapq.heappush(maxHeap, (-new_dist, r2, c2))
            