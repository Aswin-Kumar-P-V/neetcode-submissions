class Solution:
    def combinationSum(self, nums: List[int], target: int) -> List[List[int]]:
        res = []
        subset = []
        
        def dfs(i, sum):
            if sum >= target or i == len(nums):
                if sum == target:
                    res.append(subset[:])
                return
            sum += nums[i]
            subset.append(nums[i])
            dfs(i, sum)
            pop = subset.pop()
            sum -= pop
            dfs(i+1, sum)
        dfs(0, 0)
        return res