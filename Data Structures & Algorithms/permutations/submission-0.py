class Solution:
    def permute(self, nums: List[int]) -> List[List[int]]:
        res = []
        subset = []

        def dfs(i):
            if len(subset) == len(nums):
                res.append(list(subset))
                return
            
            for j in range(0, len(nums)):
                if nums[j] in subset:
                    continue
                subset.append(nums[j])
                dfs(i+1)
                subset.pop()
               

        dfs(0)
        return res