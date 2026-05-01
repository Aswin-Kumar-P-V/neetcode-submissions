class Solution {
    public int characterReplacement(String s, int k) {
        int l = 0, length = 0;
        Map<Character, Integer> map = new HashMap<>();

        for(int r = 0; r < s.length(); r++){
            map.put(s.charAt(r), map.getOrDefault(s.charAt(r), 0) + 1);
            
            int maxF = 0;
            for(int num : map.values()){
                maxF = Math.max(maxF, num);
            }
            while(l < r && r - l + 1 - maxF > k){
                map.put(s.charAt(l), map.get(s.charAt(l)) - 1);
                l++;
            }
            length = Math.max(length, r-l+1);
            
        }
        return length;
    }
}
