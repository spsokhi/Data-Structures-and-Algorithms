class Solution:
    def specialArray(self, nums: List[int]) -> int:
        nums.sort()
        i = 0
        prev = -1
        total_right = len(nums)
        
        while i < len(nums):
            if nums[i] == total_right or (prev < total_right < nums[i]):
                return total_right
            
            while i+1 < len(nums) and nums[i] == nums[i+1]:
                i += 1
            
            prev = nums[i]
            i+=1
            total_right = len(nums) - i
            
        return -1