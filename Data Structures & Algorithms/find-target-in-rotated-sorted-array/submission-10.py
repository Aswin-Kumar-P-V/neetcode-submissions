class Solution:
    def search(self, nums: List[int], target: int) -> int:
        l, r = 0, len(nums) - 1
        while l < r:
            mid = l + ((r-l)//2)
            if nums[mid] > nums[r]:
                l = mid + 1
            else:
                r = mid
        pivot = r
        l, r = 0, len(nums) - 1
        if nums[pivot] <= target <= nums[r]:
            l = pivot
        else:
            r = pivot
        while l <= r:
            mid = l + ((r-l)//2)
            if nums[mid] < target:
                l = mid + 1
            elif nums[mid] > target:
                r = mid - 1
            else:
                return mid
        return -1
