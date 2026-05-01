class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length()>s2.length()) return false;
        Map<Character, Integer> s1M = new HashMap<>();
        Map<Character, Integer> s2M = new HashMap<>();

        for(int i = 0; i < s1.length(); i++){
            s1M.put(s1.charAt(i),s1M.getOrDefault(s1.charAt(i),0)+1);
            s2M.put(s2.charAt(i),s2M.getOrDefault(s2.charAt(i),0)+1);
        }

        int matches = 0;

        for(char c: s1.toCharArray()){
            if(s1M.get(c).equals(s2M.getOrDefault(c,0))){
                matches++;
            }
        }
        int l = 0;
        for(int r = s1.length(); r < s2.length(); r++){
            if(s1M.size() == matches) return true;

            char toAdd = s2.charAt(r);

            if(s1M.containsKey(toAdd) && s1M.get(toAdd).equals(s2M.getOrDefault(toAdd,0))){
                matches--;
            }

            s2M.put(toAdd, s2M.getOrDefault(toAdd,0)+1);

            if(s1M.containsKey(toAdd) && s1M.get(toAdd).equals(s2M.getOrDefault(toAdd,0))){
                matches++;
            }

            char toRem = s2.charAt(l);

            if(s1M.containsKey(toRem) && s1M.get(toRem).equals(s2M.getOrDefault(toRem,0))){
                matches--;
            }

            s2M.put(toRem, s2M.getOrDefault(toRem,0)-1);

            if(s1M.containsKey(toRem) && s1M.get(toRem).equals(s2M.getOrDefault(toRem,0))){
                matches++;
            }

            l++;

        }
        return s1M.size() == matches;
    }
}
