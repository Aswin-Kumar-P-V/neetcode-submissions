class Solution:
    def longestConsecutive(self, nums: List[int]) -> int:
        numSet = set(nums)
        longSeq = 0
        for num in nums:
            if num - 1 not in numSet:
                curLongSeq = 1
                currentNum = num + 1
                while currentNum in numSet:
                    currentNum+=1
                    curLongSeq+=1
                longSeq = max(curLongSeq, longSeq)
        return longSeq
            
