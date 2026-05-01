class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length, cols = matrix[0].length;
        int l = 0, r = rows - 1;
        int row = -1;
        while(l <= r){
            int mid = l + ((r - l)/2);
            if(target > matrix[mid][cols-1]){
                l = mid + 1;
            }else if(target < matrix[mid][0]){
                r = mid - 1;
            }else{
                row = mid;
                break;
            }
        }
        if(row == - 1) return false;
        l = 0; r = cols - 1;
        while(l <= r){
            int mid = l + ((r - l)/2);
            if(target > matrix[row][mid]){
                l = mid + 1;
            }else if(target < matrix[row][mid]){
                r = mid - 1;
            }else{
                return true;
            }
        }
        return false;
    }
}
