class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> numIndex = new HashMap<>();
        for(int i = 0; i < nums.length;i++){
            if(numIndex.containsKey(target - nums[i])){
                return new int[]{numIndex.get(target-nums[i]), i};
            }
            numIndex.put(nums[i], i);
        }
        return new int[2];
    }
}
