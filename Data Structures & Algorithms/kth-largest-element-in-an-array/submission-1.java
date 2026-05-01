class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minStack = new PriorityQueue<>();
        for(int i = 0; i < nums.length; i++){
            minStack.offer(nums[i]);
            if (minStack.size() > k){
                minStack.poll();
            }
        }
        return minStack.peek();
    }
}
