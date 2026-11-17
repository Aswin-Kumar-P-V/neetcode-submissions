class Solution:
    def combinationSum(self, nums: List[int], target: int) -> List[List[int]]:
        res = []
        subset = []
        nums.sort()

        def dfs(i, sum):
            if sum == target:
                res.append(subset[:])
                return

            for j in range(i, len(nums)):
                if sum + nums[j] > target:
                    return
                subset.append(nums[j])
                dfs(j, sum + nums[j])
                subset.pop()
              

        dfs(0, 0)
        return res