class Solution {
    public int maxArea(int[] heights) {
        int area = 0, l = 0, r = heights.length - 1;
        while(l < r){
            int newArea = (r - l) * Math.min(heights[l],heights[r]);
            area = Math.max(area, newArea);
            if(heights[l] < heights[r]){
                l++;
            }else{
                r--;
            }
        }
        return area;
    }
}
