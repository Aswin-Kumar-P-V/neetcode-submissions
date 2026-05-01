class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        List<Integer>[] freqList = new List[nums.length + 1];
        for(int i = 0; i < freqList.length; i++){
            freqList[i] = new ArrayList<>();
        }
        Map<Integer, Integer> freqMap = new HashMap<>();
        for(int num : nums){
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }
        for(Map.Entry<Integer, Integer> entry : freqMap.entrySet()){
            freqList[entry.getValue()].add(entry.getKey());
        }
        int index = 0;
        int[] res = new int[k];
        for(int i = freqList.length - 1; i > 0;i--){
            for(int num : freqList[i]){
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
