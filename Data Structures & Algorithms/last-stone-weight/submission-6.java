class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>();
        for(int stone : stones){
            maxHeap.offer(-stone);
        }
        while(maxHeap.size() > 1){
            int res = maxHeap.poll() - maxHeap.poll();
            if(res < 0){
                maxHeap.offer(res);
            }
        }
        return maxHeap.size() > 0 ? -maxHeap.peek() : 0;
    }
}
