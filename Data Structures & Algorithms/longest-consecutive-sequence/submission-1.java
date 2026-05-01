class Solution {
    public int longestConsecutive(int[] nums) {
        int longestStreak = 0;
        Set<Integer> numSet = new HashSet<>();
        for(int num : nums){
            numSet.add(num);
        }

        for(int num : nums){
            if(numSet.contains(num - 1)){
                continue;
            }else{
                int currentStreak = 0;
                int currentNum = num; 
                while(numSet.contains(currentNum)){
                    currentNum++;
                    currentStreak++;
                }
                longestStreak = Math.max(currentStreak, longestStreak);
            }
        }

        return longestStreak;
    }
}
