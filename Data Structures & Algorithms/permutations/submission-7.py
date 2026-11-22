class Solution:
    def permute(self, nums: List[int]) -> List[List[int]]:
        res = []
        subset = []
        index_set = set()

        def dfs():
            if len(subset) == len(nums):
                res.append(subset.copy())
                return
            
            for j in range(len(nums)):
                if j in index_set:
                    continue
                subset.append(nums[j])
                index_set.add(j)
                dfs()
                subset.pop()
                index_set.remove(j)
               

        dfs()
        return res