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

        List<Pair<Integer, String>> values = timeMap.get(key);
        int l = 0, r = values.size() - 1;
        String res = "";
        while(l <= r){
            int mid = l + (r - l) / 2;
            if(values.get(mid).gK() <= timestamp){
                res = values.get(mid).gV();
                l = mid + 1;
            }else{
                r = mid - 1;
            }
        }
        return res;
    }

    public static class Pair<K, V>{
        private final K key;
        private final V value;

        public Pair(K key, V value){
            this.key = key;
            this.value = value;
        }

        public K gK(){
            return key;
        }

        public V gV(){
            return value;
        }
    }
}
