class Solution:
    def longestConsecutive(self, nums: List[int]) -> int:
        unique_nums = set(nums)
        long = 0
        for num in nums:
            current = 1
            while(num + 1 in unique_nums):
                current += 1
                num += 1
            long = max(long, current)
        return long