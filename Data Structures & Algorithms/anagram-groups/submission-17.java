class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> sMap = new HashMap<>();
        for(String str : strs){
            char[] sChar = str.toCharArray();
            Arrays.sort(sChar);
            String key = new String(sChar);
            sMap.computeIfAbsent(key, k -> new ArrayList<>());
            sMap.get(key).add(str);
        }
        return new ArrayList<>(sMap.values());
    }
}
