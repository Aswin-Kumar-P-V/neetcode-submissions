class Solution {
    public boolean hasDuplicate(int[] nums) {
        Set<Integer> unique = new HashSet<>();
        for(int num : nums){
            unique.add(num);
        }
        return !(unique.size() == nums.length);
    }
}