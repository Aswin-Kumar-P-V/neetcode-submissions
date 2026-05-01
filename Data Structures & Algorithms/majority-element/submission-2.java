class Solution {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> freq = new HashMap<>();
        for(int num : nums){
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }
        int maj = nums.length / 2;
        for(int key : freq.keySet()){
            if(freq.get(key) > maj){
                return key;
            }
        }
        return 0;
    }
}