class UnionFind:
    def __init__(self, n):
        self.parent = [i for i in range(n)]
        self.size = [1] * n
        self.count = n
        
    def find(self, x):
        if self.parent[x] != x:
            self.parent[x] = self.find(self.parent[x])
        return self.parent[x]
    
    def union(self, x, y): # connect componets
        px, py = self.find(x), self.find(y) # px: parent of x, py: parent of y
        if px == py:
            return
        if self.size[px] < self.size[py]:
            self.parent[px] = py
            self.size[py] += self.size[px]
        else:
            self.parent[py] = px
            self.size[px] += self.size[py]
        self.count -= 1

class Solution:
    def canTraverseAllPairs(self, nums: List[int]) -> bool:
        uf = UnionFind(len(nums))
        
        factor_index = {} # f -> index of value with factor f
        for i, n in enumerate(nums):
            f = 2
            while f * f <= n:
                if n % f == 0:
                    if f in factor_index:
                        uf.union(i, factor_index[f])
                    else:
                        factor_index[f] = i
                    while n % f == 0:
                        n = n // f
                f += 1
            if n > 1:
                if n in factor_index:
                    uf.union(i, factor_index[n])
                else:
                    factor_index[n] = i
                    
        return uf.count == 1
        
        
        
        
        
        
        
        
        
        
        
# if you have a single connected graph return true
# go through each num in nums and find all its prime factors
# if there a common factor between two elements then there is an edge between them
# going through nums in : O(n)
# finding prime factors in: O(n^1/2)        