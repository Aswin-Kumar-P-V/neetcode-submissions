class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> sMap = new HashMap<>();
        for(String str : strs){
            char[] schar = str.toCharArray();
            Arrays.sort(schar);
            String key = new String(schar);
            sMap.computeIfAbsent(key, k-> new ArrayList<>());
            sMap.get(key).add(str);
        }
        return new ArrayList<>(sMap.values());
    }
}
