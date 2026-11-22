class Solution:
    def permute(self, nums: List[int]) -> List[List[int]]:
        res = []
        subset = []

        def dfs():
            if len(subset) == len(nums):
                res.append(list(subset))
                return
            
            for j in range(len(nums)):
                if nums[j] in subset:
                    continue
                subset.append(nums[j])
                dfs()
                subset.pop()
               

        dfs()
        return res