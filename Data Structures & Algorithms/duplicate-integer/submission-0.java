class Solution {
    public boolean hasDuplicate(int[] nums) {
        ArrayList checkDuplicates = new ArrayList();
        for(int i = 0; i<nums.length;i++){
            if(checkDuplicates.contains(nums[i])){
                return true;
            }
            checkDuplicates.add(nums[i]);
        }
        return false;
    }
}