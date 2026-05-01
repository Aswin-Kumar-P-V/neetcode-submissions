class Solution {
    public int longestConsecutive(int[] nums) {
        int res = 0;
        Set<Integer> numSet = new HashSet<>();
        for(int num : nums){
            numSet.add(num);
        }
        for(int num : nums){
            int longest = 1;
            int current = num;
            while(numSet.contains(current + 1)){
                longest++;
                current++;
            }
            res = Math.max(res, longest);
        }
        return res;
    }
}
