class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> numSet = new HashSet<>();
        for(int num : nums){
            numSet.add(num);
        }
        int max = 0;
        for(int num : nums){
            int curr = num;
            int longest  = 1;
            if(!numSet.contains(curr - 1)){
                while(numSet.contains(curr + 1)){
                    longest++;
                    curr++;
                }
            }
            max = Math.max(longest, max);
        }
        return max;
    }
}
