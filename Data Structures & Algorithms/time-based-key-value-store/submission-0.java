class TimeMap {

    private Map<String, List<Pair<Integer, String>>> timeMap;

    public TimeMap() {
        timeMap = new HashMap<>();    
    }
    
    public void set(String key, String value, int timestamp) {
        if(!timeMap.containsKey(key)){
            timeMap.put(key, new ArrayList<>());
        }
        timeMap.get(key).add(new Pair(timestamp, value));
    }
    
    public String get(String key, int timestamp) {
        if(!timeMap.containsKey(key)) return "";
        List<Pair<Integer, String>> timeMapValues = timeMap.get(key);
        String res = ""; 
        int l = 0, r = timeMapValues.size() - 1;
        while(l <= r){
            int mid = l + (r - l) / 2;
            if(timeMapValues.get(mid).getKey() <= timestamp){
                res = timeMapValues.get(mid).getValue();
                l = mid + 1;
            }else{
                r= mid - 1;
            }
        }
        return res;
    }

    private static class Pair<K, V>{
        private final K key;
        private final V value;

        public Pair(K key, V value){
            this.key = key;
            this.value = value;
        }

        public K getKey(){
            return key;
        }

        public V getValue(){
            return value;
        }
    }
}
