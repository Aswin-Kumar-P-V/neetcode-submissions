class Solution:
    def permute(self, nums: List[int]) -> List[List[int]]:
        res = []
        subset = []
        index_set = set()

        def dfs():
            if len(subset) == len(nums):
                res.append(list(subset))
                return
            
            for j in range(len(nums)):
                if j in index_set:
                    continue
                subset.append(nums[j])
                index_set.add(j)
                dfs()
                index = nums.index(subset.pop())
                index_set.remove(index)
               

        dfs()
        return res