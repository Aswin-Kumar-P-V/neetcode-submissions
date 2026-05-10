class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> ref = new HashSet<>();
        int maxLength = 0;
        int l = 0;
        for(int r = 0; r < s.length(); r++){
            char curr = s.charAt(r);
            while(l < r && ref.contains(curr)){
                ref.remove(s.charAt(l));
                l++;
            }
            ref.add(curr);
            maxLength = Math.max(maxLength, ref.size());
        }
        return maxLength;
    }
}