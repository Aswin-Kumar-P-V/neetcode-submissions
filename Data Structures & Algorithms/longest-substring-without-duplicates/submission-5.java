class Solution {
    public int lengthOfLongestSubstring(String s) {
        int l = 0, length = 0;
        Set<Character> set = new HashSet<>();
        for(int r = 0; r < s.length();r++){
            while(l < r && set.contains(s.charAt(r))){
                set.remove(s.charAt(l));
                l++;
            }
            set.add(s.charAt(r));
            length = Math.max(length, set.size());
        }
        return length;
  
    }
}
