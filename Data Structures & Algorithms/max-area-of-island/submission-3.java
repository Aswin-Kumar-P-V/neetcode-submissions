class Solution {
    int[][] dir = {{1,0}, {-1,0},{0,1},{0,-1}};
    public int maxAreaOfIsland(int[][] grid) {
        int rows = grid.length, cols = grid[0].length, area = 0;
        for(int r = 0; r < rows ; r++){
            for(int c = 0; c < cols; c++){
                if(grid[r][c] == 1){
                    area = Math.max(area, dfs(grid, r, c));
                }
            }
        }
        return area;

    }
    private int dfs(int[][] grid, int r, int c){
        if(r < 0 || c < 0 || r >= grid.length || c >= grid[0].length || grid[r][c] == 0){
            return 0;
        }
        grid[r][c] = 0;
        int area = 1;
        for(int[] d : dir){
            area += dfs(grid , r + d[0], c + d[1]);
        }
        return area;
    }
}
