class Solution {
    public int findDuplicate(int[] nums) {
        Arrays.sort(nums);
        int res = nums[0];
        for(int i = 1; i < nums.length ; i++){
            if(nums[i] == nums[i-1]){
                res = nums[i];
                break;
            }
        }
        return res;
    }
}
