class Solution:
    def productExceptSelf(self, nums: List[int]) -> List[int]:
        res = [1 for i in range(len(nums))]
        for i in range(1, len(nums)):
            res[i] = res[i-1] * nums[i-1]
        k = 1
        for i in range(len(nums) - 2, -1, -1):
            k *= nums[i+1]
            res[i] *= k
        return res


