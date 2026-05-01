class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int num : nums){
            set.add(num);
        }
        int longestStreak = 0;
        for(int num : nums){
            if(set.contains(num - 1)) continue;
            int currentStreak = 1;
            int currentNum = num + 1;
            while(set.contains(currentNum)){
                currentStreak++;
                currentNum++;
            }
            longestStreak = Math.max(longestStreak, currentStreak);
        }
        return longestStreak;
    }
}
