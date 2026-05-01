class Solution {
    public void islandsAndTreasure(int[][] grid) {
        int[][] directions = {{1,0}, {0,1}, {-1,0}, {0,-1}};
        int rows = grid.length, cols = grid[0].length,dist = 0;
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[rows][cols];
        for(int r = 0; r < rows;r++){
            for(int c = 0; c < cols; c++){
                if(grid[r][c] == 0){
                    q.add(new int[]{r,c});
                    visited[r][c] = true;
                }
            }
        }
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i < size; i++){
                int[] temp = q.poll();
                int row = temp[0], col = temp[1];
                grid[row][col] = dist;
                for(int[] dir : directions){
                    addToQueue(grid, row + dir[0], col + dir[1], q, visited);
                }
            }
            dist++;
        }
    }
    private void addToQueue(int[][] grid, int r, int c, Queue<int[]> q, boolean[][] visited){
        if(r < 0 || c < 0 || r >= grid.length || c >= grid[0].length || grid[r][c] == -1 || visited[r][c]){
            return;
        }
        q.add(new int[]{r,c});
        visited[r][c] = true;
    }
}
