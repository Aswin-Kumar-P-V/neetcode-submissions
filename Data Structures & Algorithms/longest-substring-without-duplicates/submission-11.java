class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length() == 0 ) return 0;
        int l = 0, r = 0, maxLength = 0;
        Set<Character> set = new HashSet<>();
        while(r < s.length()){
            while(l < r && set.contains(s.charAt(r))){
                set.remove(s.charAt(l));
                l++;
            }
            set.add(s.charAt(r));
            r++;
            maxLength = Math.max(maxLength, set.size());
        }
        return maxLength;
    }
}
