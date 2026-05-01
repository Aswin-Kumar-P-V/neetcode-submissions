class Solution {
    public int maxArea(int[] heights) {
        int l = 0, r = heights.length - 1;
        int maxWater = 0;
        while(l < r){
            int currentWater = Math.abs(l - r) * Math.min(heights[l], heights[r]);
            maxWater = Math.max(currentWater, maxWater);
            if(heights[l] < heights[r]){
                l++;
            }else{
                r--;
            }
        }
        return maxWater;
    }
}
