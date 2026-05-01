class Solution {
    public int maxArea(int[] heights) {
        int maxWater = 0;
        int l = 0, r = heights.length - 1;
        while(l < r){
            int currArea = (r - l) * Math.min(heights[l], heights[r]);
            maxWater = Math.max(currArea, maxWater);
            if(heights[r] < heights[l]){
                r--;
            }else{
                l++;
            }
        }
        return maxWater;
    }
}
