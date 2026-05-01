class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        for(int num : nums){
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }
        List<Integer>[] bucketSort = new List[nums.length + 1];
        for(int i = 0; i < bucketSort.length; i++){
            bucketSort[i] = new ArrayList<>();
        }
        for(Map.Entry<Integer, Integer> entry : freqMap.entrySet()){
            bucketSort[entry.getValue()].add(entry.getKey());
        }
        int[] res = new int[k];
        int index = 0;
        for(int i = bucketSort.length - 1; i >= 0; i--){
            for(int num : bucketSort[i]){
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
