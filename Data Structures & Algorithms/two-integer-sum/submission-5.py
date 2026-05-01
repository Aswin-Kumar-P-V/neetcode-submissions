class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        map = {}
        for i in range(0, len(nums)):
            sum = target - nums[i]
            if sum in map:
                return [map.get(sum), i]
            map[nums[i]] = i
        return [0,0]