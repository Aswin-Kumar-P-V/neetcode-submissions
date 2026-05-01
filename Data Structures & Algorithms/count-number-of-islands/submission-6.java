class Solution {
    int[][] directions = {{1,0},{-1,0},{0,1},{0,-1}};
    public int numIslands(char[][] grid) {
        int rows = grid.length, cols = grid[0].length, islands = 0;
        for(int r = 0; r < rows;r++){
            for(int c = 0; c < cols; c++){
                if(grid[r][c] == '1'){
                    dfs(grid, r, c);
                    islands++;
                }
            }
        }
        return islands;
    }
    private void dfs(char[][] grid,int r,int c){
        if(c < 0 || r < 0 || r >= grid.length || c >= grid[0].length || grid[r][c] == '0'){
            return;
        }
        grid[r][c] = '0';
        for(int[] dir : directions){
            dfs(grid, r + dir[0], c + dir[1]);
        }
    }
}
