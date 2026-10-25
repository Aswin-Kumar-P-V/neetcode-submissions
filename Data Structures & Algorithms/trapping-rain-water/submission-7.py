class Solution:
    def trap(self, height: List[int]) -> int:
        if not height:
            return 0
        l, r = 0, len(height) - 1
        res = 0
        maxleft, maxright = height[l], height[r]
        while l < r:
            if maxleft <= maxright:
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