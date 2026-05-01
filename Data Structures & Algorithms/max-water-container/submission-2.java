class Solution {
    public int maxArea(int[] heights) {
        int res = 0, l = 0, r = heights.length - 1;
        while(l < r){
            int water = (r-l) * Math.min(heights[l], heights[r]);
            res = Math.max(water, res);
            if(heights[l] < heights[r]){
                l++;
            }
            else{
                r--;
            }
        }
        return res;
    }
}
