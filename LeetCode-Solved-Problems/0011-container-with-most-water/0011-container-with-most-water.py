class Solution:
    def maxArea(self, height: List[int]) -> int:
        # two pointer approach
        
        l=0
        r=len(height)-1
        max_water=0
        while l<r:
            water=min(height[l],height[r])*(r-l) # water = area = hight * width
            max_water=max(water,max_water)
            if height[l] < height[r]:
                l+=1
            else:
                r-=1
                
        return max_water
                    