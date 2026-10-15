class Solution:
    def longestConsecutive(self, nums: List[int]) -> int:
        numSet = set(nums)
        res = 0
        for num in nums:
            if not num - 1 in numSet:
                currLongest = 1
                curr = num
                while curr + 1 in numSet:
                    currLongest += 1
                    curr += 1
                res = max(res, currLongest)
            
        return res