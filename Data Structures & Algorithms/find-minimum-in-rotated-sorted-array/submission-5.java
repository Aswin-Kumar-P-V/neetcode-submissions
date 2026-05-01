class Solution {
    public int findMin(int[] nums) {
        int l = 0, r = nums.length - 1, res = nums[0];
        while(l <= r){
            int mid = l + (r - l) / 2;
            if(nums[l] < nums[r]){
                res = Math.min(res, nums[l]);
                break;
            }
            res = Math.min(res, nums[mid]);

            if(nums[mid] >= nums[l]){
                l = mid + 1;
            }else{
                r = mid - 1;
            }
        }
        return res;
    }
}


