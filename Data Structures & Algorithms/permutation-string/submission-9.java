class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length()) return false;
        int len = s1.length();
        Map<Character, Integer> s1Map = new HashMap<>();
        Map<Character, Integer> s2Map = new HashMap<>();
        for(int i = 0; i < len;i++){
            s1Map.put(s1.charAt(i), s1Map.getOrDefault(s1.charAt(i),0) + 1);
            if(i < len - 1){
                s2Map.put(s2.charAt(i), s2Map.getOrDefault(s2.charAt(i), 0) + 1);
            }
        }
        int l = 0, r = len - 1;
        while(r < s2.length()){
            char s2r = s2.charAt(r);
            s2Map.put(s2r, s2Map.getOrDefault(s2r, 0) + 1);
            if(s1Map.equals(s2Map)) return true;
            char s2l = s2.charAt(l);
            s2Map.put(s2l, s2Map.getOrDefault(s2l, 0) - 1);
            if(s2Map.get(s2l) == 0){
                s2Map.remove(s2l);
            }
            l++;r++;
        }
        return false;
    }
}
