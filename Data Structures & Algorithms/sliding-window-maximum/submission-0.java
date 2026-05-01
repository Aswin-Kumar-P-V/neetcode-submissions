class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] res = new int[n-k+1];
        int l = 0, r = 0, resIndex = 0;
        Deque<Integer> que = new LinkedList<>();

        while(r < n){
            while(!que.isEmpty() && nums[que.getLast()] < nums[r]){
                que.removeLast();
            }
            que.addLast(r);

            if(l > que.getFirst()){
                que.removeFirst();
            }

            if((r+1) >= k){
                res[resIndex] = nums[que.getFirst()];
                resIndex++;l++;
            }
            r++;
        }
        return res;
        
    }
}
