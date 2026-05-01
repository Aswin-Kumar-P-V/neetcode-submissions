class Solution {
    public int[] productExceptSelf(int[] nums) {
        int pre = 1;
        int[] res = new int[nums.length];
        res[0] = 1;
        for(int i = 1; i < nums.length; i++){
            res[i] = pre * nums[i-1];
            pre = pre * nums[i-1];
        }
        int post = 1;
        for(int i = nums.length - 1; i >= 0; i--){
            res[i] = post * res[i];
            post = post * nums[i];
        }
        return res;
    }
}  
// [1,2,4,6]
// pre = 1
// [1,1,2,8]
// [48,24,12,8]