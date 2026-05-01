class Solution {
    public int lengthOfLongestSubstring(String s) {
        int l = 0, r = 0, length = 0;
        Set<Character> set = new HashSet<>();
        while(r < s.length()){
            while(l < r && set.contains(s.charAt(r))){
                set.remove(s.charAt(l));
                l++;
            }
            set.add(s.charAt(r));
            length = Math.max(length, r - l + 1);
            r++;
        }
        return length;
    }
}
