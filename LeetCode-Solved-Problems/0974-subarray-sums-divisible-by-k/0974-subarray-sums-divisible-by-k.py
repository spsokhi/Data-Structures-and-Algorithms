class Solution:
    def subarraysDivByK(self, nums: List[int], k: int) -> int:
        # time: O(n), space: O(k)
        prefix_sum = 0
        ans = 0
        
        prefix_cnt = defaultdict(int)
        prefix_cnt[0] = 1
        
        for n in nums:
            prefix_sum += n
            remainder = prefix_sum % k
            
            if remainder in prefix_cnt:
                ans += prefix_cnt[remainder]
                
            prefix_cnt[remainder] += 1
        
        return ans