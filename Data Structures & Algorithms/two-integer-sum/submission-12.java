class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> numIndexValue = new HashMap<>();
        for(int index = 0; index < nums.length; index++){
            int operand = target - nums[index];
            if(numIndexValue.containsKey(operand)){
                return new int[]{numIndexValue.get(operand), index};
            }
            numIndexValue.put(nums[index], index);
        }
        return new int[2];
    }
}
