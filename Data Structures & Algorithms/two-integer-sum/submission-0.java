class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> numsMap = new HashMap<>();
        numsMap.put(nums[0], 0);
        for(int i = 1; i < nums.length;i++){
            if(numsMap.containsKey(target-nums[i])) return new int[] {numsMap.get(target-nums[i]), i};
            numsMap.put(nums[i], i);
        }
        return new int[2];
    }
}
