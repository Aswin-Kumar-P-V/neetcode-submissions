class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();
        for(int num: nums){
            freq.put(num, freq.getOrDefault(num, 0 ) + 1);
        }
        List<Integer>[] bSort = new List[nums.length+1];
        for(int i = 0; i < bSort.length; i++){
            bSort[i] = new ArrayList<>();
        }
        for(Map.Entry<Integer, Integer> entry :  freq.entrySet()){
            bSort[entry.getValue()].add(entry.getKey());
        }
        int[] res = new int[k];
        int index = 0;
        for(int i = bSort.length - 1; i > 0;i--){
            for(int n : bSort[i]){
                res[index] = n;
                index++;
                if(index == k) return res;
            }
        }
        return res;
    }
}
