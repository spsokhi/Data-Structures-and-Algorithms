class Solution:
    def minFallingPathSum(self, grid: List[List[int]]) -> int:
        # neetcode very clever solution
        def get_min_two(row):
            two_smallest = [] # (val, indx)
            for val, indx in row:
                if len(two_smallest)<2:
                    two_smallest.append((val,indx))
                    
                elif two_smallest[1][0] > val:
                    two_smallest.pop()
                    two_smallest.append((val,indx))
                two_smallest.sort()
                
            return two_smallest
        
        n = len(grid)
        first_row = [(val,indx) for indx, val in enumerate(grid[0])]
        prev_dp = get_min_two(first_row)
        
        for r in range(1,n):
            dp = [] # (val,indx)
            for curr_c in range(n):
                curr_val = grid[r][curr_c]
                min_val = float("inf")
                for prev_val, prev_c in prev_dp:
                    if curr_c != prev_c:
                        min_val = min(min_val, curr_val + prev_val)
                dp.append((min_val, curr_c))
                dp = get_min_two(dp)
            prev_dp = dp
            
        return min([val for val,indx in prev_dp])