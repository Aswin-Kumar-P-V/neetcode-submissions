class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int num : nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        List<Integer>[] count = new List[nums.length + 1];
        for(int i = 0; i < count.length; i++){
            count[i] = new ArrayList<>();
        }
        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            count[entry.getValue()].add(entry.getKey());
        }
        int index = 0;
        int[] res = new int[k];
        for(int i = count.length - 1; i >= 0; i--){
            for(int num : count[i]){
                res[index] = num;
                index++;
                if(index == k) return res;
            }
        }
        return res;
    }
}
