class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> res = new HashMap<>();
        for(String s: strs){
            char[] charS = s.toCharArray();
            Arrays.sort(charS);
            String stringS = new String(charS);
            if(!res.containsKey(stringS)){
                res.put(stringS, new ArrayList<String>());
            }
            res.get(stringS).add(s);
            
        }
        return new ArrayList<>(res.values());
    }
}
