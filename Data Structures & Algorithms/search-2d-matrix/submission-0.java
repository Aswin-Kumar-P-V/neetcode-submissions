class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length, cols = matrix[0].length;
        int top = 0, bottom = rows-1;
        while(top <= bottom){
            int row = (top + bottom) / 2;
            if(matrix[row][0] > target) {
                bottom = row - 1;
            }else if(matrix[row][cols - 1] < target){
                top = row + 1;
            }else{
                break;
            }
        }
        if(bottom < top) return false;

        int l = 0,  r = cols - 1;
        int row = (top+bottom) / 2;
        while(l <= r){
            int mid = l + (r-l)/2;
            if(target > matrix[row][mid]){
                l = mid+1;
            }else if(target < matrix[row][mid]){
                r = mid - 1;
            }else{
                return true;
            }
        }
        return false;
    }
}
