class Solution {
    public int search(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while(l < r){
            int mid = l + ((r-l)/2);
            if(nums[mid] > nums[r]){
                l = mid + 1;
            }else{
                r = mid;
            }
        }
        int pivot = r;
        l = 0;
        r = nums.length - 1;
        if(target >= nums[pivot] && target <= nums[r]){
            l = pivot;
        }else{
            r = pivot;
        }
        while(l <= r){
            int mid = l + ((r -l)/2);
            if(target > nums[mid]){
                l = mid + 1;
            }else if(target < nums[mid]){
                r = mid - 1;
            }else{
                return mid;
            }
        }
        return -1;
    }
}
