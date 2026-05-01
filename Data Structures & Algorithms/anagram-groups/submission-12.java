class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> strMap = new HashMap<>();
        for(String str : strs){
            char[] cArray = str.toCharArray();
            Arrays.sort(cArray);
            String key = new String(cArray);
            strMap.computeIfAbsent(key, k ->new ArrayList<>());
            strMap.get(key).add(str);
        }
        return new ArrayList<>(strMap.values());
    }
}
