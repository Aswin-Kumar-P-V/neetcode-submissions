class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        map = {}
        for i, n in enumerate(nums):
            sum = target - n
            if sum in map:
                return [map[sum], i]
            map[n] = i
        