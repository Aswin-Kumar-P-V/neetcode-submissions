class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> valIndexMap = new HashMap<>();
        for(int i = 0; i < nums.length;i++){
            int val = target - nums[i];
            if(valIndexMap.containsKey(val)){
                return new int[]{valIndexMap.get(val), i};
            }
            valIndexMap.put(nums[i], i);
        }
        return new int[]{0,0};
    }
}
