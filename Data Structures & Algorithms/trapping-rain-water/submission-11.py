class Solution:
    def trap(self, height: List[int]) -> int:
        max_water = 0
        l, r = 0, len(height) - 1
        maxL = height[l]
        maxR = height[r]
        while l < r:
            if maxL <= maxR:
                l += 1
                water = maxL - height[l]
                max_water += water if water > 0 else 0
                maxL = max(maxL, height[l])
                
            else:
                r -= 1
                water = maxR - height[r]
                max_water += water if water > 0 else 0
                maxR = max(maxR, height[r])
                
        return max_water
