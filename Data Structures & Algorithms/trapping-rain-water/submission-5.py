class Solution:
    def trap(self, height: List[int]) -> int:
        res = 0
        l, r = 0, len(height) - 1
        maxleft, maxright = height[l], height[r]
        while l < r:
            if height[l] <= height[r]:
                l += 1
                water = maxleft - height[l]
                res += water if water > 0 else 0
                maxleft = max(maxleft, height[l])
            else:
                r -= 1
                water = maxright - height[r]
                res += water if water > 0 else 0
                maxright = max(maxright, height[r])
        return res