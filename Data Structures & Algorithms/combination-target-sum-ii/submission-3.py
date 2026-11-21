class Solution:
    def combinationSum2(self, candidates: List[int], target: int) -> List[List[int]]:
        res = []
        subset = []
        candidates.sort()
        def dfs(i, sum):
            if sum == target:
                res.append(subset[:])
                return
            for j in range(i, len(candidates)):
                if j > i and candidates[j - 1] == candidates[j]:
                    continue
                if sum + candidates[j] > target:
                    return
                subset.append(candidates[j])
                dfs(j + 1, sum + candidates[j])
                subset.pop()

        dfs(0, 0)
        return res