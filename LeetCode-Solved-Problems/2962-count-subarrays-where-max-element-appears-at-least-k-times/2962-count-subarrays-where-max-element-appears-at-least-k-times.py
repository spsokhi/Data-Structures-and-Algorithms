class Solution:
    def countSubarrays(self, nums: List[int], k: int) -> int:
        mx, cnt = max(nums), 0
        l = 0
        ans = 0
        
        for r in range(len(nums)):
            if nums[r] == mx:
                cnt += 1
            while cnt == k:
                if nums[l] == mx:
                    cnt -= 1
                l += 1
            ans += l
                
        return ans