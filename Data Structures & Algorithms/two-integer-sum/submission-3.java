class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> valInd = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            int sum = target - nums[i];
            if(valInd.containsKey(sum)){
                return (new int[]{valInd.get(sum), i});
            }
            valInd.put(nums[i], i);
        }
        return new int[]{};
    }
}
