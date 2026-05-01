class Solution {
    public String minWindow(String s, String t) {
        if(t.isEmpty()) return "";
        Map<Character, Integer> needM = new HashMap<>();
        Map<Character, Integer> haveM = new HashMap<>();

        for(char c : t.toCharArray()){
            needM.put(c, needM.getOrDefault(c,0)+1);
        }

        int l = 0, need = needM.size(), resLen = Integer.MAX_VALUE, have = 0;
        int[] res = new int[]{ -1, -1};

        for(int r = 0 ; r < s.length(); r++){
            char R = s.charAt(r);
            haveM.put(R, haveM.getOrDefault(R, 0) + 1);
            if(needM.containsKey(R) && haveM.get(R).equals(needM.get(R))){
                have++;
            }
            while(have == need){
                if((r - l + 1) < resLen){
                    resLen = r - l + 1;
                    res[0] = l;
                    res[1] = r;
                }
                char L = s.charAt(l);
                haveM.put(L, haveM.getOrDefault(L, 0) - 1);
                if(needM.containsKey(L) && haveM.get(L) < needM.get(L)){
                    have--;
                }
                l++;
            }
        }
        return resLen == Integer.MAX_VALUE ? "" : s.substring(res[0], res[1]+1);
    }
}
