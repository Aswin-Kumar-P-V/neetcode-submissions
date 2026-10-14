class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        numHash = {}
        for i in range(len(nums)):
            operand = target - nums[i]
            if operand in numHash:
                return [numHash[operand], i]
            numHash[nums[i]] = i
        