class Solution:
    def maxArea(self, heights: List[int]) -> int:
        max_water = l = 0
        r = len(heights) - 1
        while l < r:
            current = (r - l) * min(heights[l], heights[r])
            max_water = max(current, max_water)
            if heights[r] < heights[l]:
                r -= 1
            else:
                l += 1
        return max_water
        