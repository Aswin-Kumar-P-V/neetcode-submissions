class Solution {
    public List<Integer> majorityElement(int[] nums) {
        Map<Integer, Integer> count = new HashMap<>();
        for(int num : nums){
            count.put(num, count.getOrDefault(num, 0) + 1);
        }
        List<Integer> res = new ArrayList<>();
        int fre = nums.length / 3;
        for(int key : count.keySet()){
            if(count.get(key) > fre){
                res.add(key);
            }
        }
        return res;
    }
}