class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for(String str : strs){
            char[] c1 = str.toCharArray();
            Arrays.sort(c1);
            String key = new String(c1);
            List<String> anagrams = map.getOrDefault(key, new ArrayList<>());
            anagrams.add(str);
            map.put(key, anagrams);
        }
        List<List<String>> res = new ArrayList<>();
        for(List<String> anagrams : map.values()){
            res.add(anagrams);
        }
        return res;
    }
}
