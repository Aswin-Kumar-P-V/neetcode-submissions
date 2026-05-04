class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> numSet = new HashSet<>();
        for(int num : nums){
            numSet.add(num);
        }
        int res = 0;
        for(int num : nums){
            if(numSet.contains(num - 1)) continue;
            int curRes = 1;
            int numGreater = num + 1;
            while(numSet.contains(numGreater)){
                numGreater++;
                curRes++;
            }
            res = Math.max(res, curRes);
        }
        return res;
    }
}
