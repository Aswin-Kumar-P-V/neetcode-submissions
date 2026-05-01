class Solution {
    public int characterReplacement(String s, int k) {
        int res = 0, l = 0;
        Map<Character, Integer> count = new HashMap<>();
        for(int r = 0; r < s.length(); r++){
            char atR = s.charAt(r);
            count.put(atR, count.getOrDefault(atR, 0) + 1);

            int maxF = 0;
            if(!count.isEmpty()){
                for(int max : count.values()){
                    maxF = Math.max(maxF, max);
                }
            }

            while( (r - l + 1) - maxF > k){
                char arL = s.charAt(l);
                count.put(arL, count.getOrDefault(arL, 0) - 1);
                l++;
                maxF = 0;
                if(!count.isEmpty()){
                    for(int max : count.values()){
                        maxF = Math.max(maxF, max);
                    }
                }
            }

            res = Math.max(res,r - l + 1);
        }
        return res;
    }
}
