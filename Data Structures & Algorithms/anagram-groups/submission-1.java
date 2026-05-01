class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map = new HashMap<>();
        List<List<String>> res = new ArrayList<>();
        for(String str : strs){
            char[] c = str.toCharArray();
            Arrays.sort(c);
            String key = new String(c);
            List<String> anagrams = map.getOrDefault(key, new ArrayList<>());
            anagrams.add(str);
            map.put(key, anagrams);
        }
        for(List<String> anagrams : map.values()){
            res.add(anagrams);
        }
        return res;
    }
}
