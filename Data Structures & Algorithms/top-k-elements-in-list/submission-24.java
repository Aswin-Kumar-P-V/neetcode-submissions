class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        for(int num : nums){
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }
        List<Integer>[] buckSort = new List[nums.length + 1];
        for(int i = 0; i < buckSort.length; i++){
            buckSort[i] = new ArrayList<>();
        }
        for(Map.Entry<Integer, Integer> entry : freqMap.entrySet()){
            buckSort[entry.getValue()].add(entry.getKey());
        }
        int index = 0;
        int[] res = new int[k];
        for(int i = buckSort.length - 1; i > -1 ; i--){
            for(int num : buckSort[i]){
                res[index] = num;
                index++;
                if(index == k){
                    return res;
                }
            }
        }
        return res;
    }
}
