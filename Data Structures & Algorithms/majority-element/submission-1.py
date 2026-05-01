class Solution:
    def majorityElement(self, nums: List[int]) -> int:
        map = {}
        for num in nums:
            map[num] = map.get(num, 0) + 1
        for key in map:
            if map[key] >= len(nums) // 2:
                return key