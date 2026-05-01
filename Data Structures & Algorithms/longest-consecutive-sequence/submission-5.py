class Solution:
    def longestConsecutive(self, nums: List[int]) -> int:
        num_set = set(nums)
        longest = 0
        for num in nums:
            current = 1
            while num + 1 in num_set:
                current+= 1
                num += 1
            num_set.add(num)
            longest=max(longest, current)
        return longest

        