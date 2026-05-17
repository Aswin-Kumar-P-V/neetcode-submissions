class Solution:
    def longestConsecutive(self, nums: List[int]) -> int:
        numSet = set(nums)
        maxLength = 0
        for num in nums:
            if num - 1 not in numSet:
                curr = 1
                while num + 1 in numSet:
                    num = num + 1
                    curr += 1
                maxLength = max(maxLength, curr)
        return maxLength

        