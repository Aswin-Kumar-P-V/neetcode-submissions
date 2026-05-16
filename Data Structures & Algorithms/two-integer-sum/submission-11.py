class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        map = {}
        for i, num in enumerate(nums):
            operand = target - num
            if operand in map:
                return [map[operand], i]
            map[num] = i
        