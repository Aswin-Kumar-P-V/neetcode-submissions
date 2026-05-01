class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> stringSet = new HashSet<>();
        int l = 0;
        int maxLength = 0;
        for(int r = 0; r < s.length();r++){
            while(stringSet.contains(s.charAt(r))){
                stringSet.remove(s.charAt(l));
                l++;
            }
            stringSet.add(s.charAt(r));
            maxLength = Math.max(maxLength, stringSet.size());
        }
        return maxLength;
    }
}
