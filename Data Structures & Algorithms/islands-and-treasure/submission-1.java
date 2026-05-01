class Solution {
    public void islandsAndTreasure(int[][] grid) {
        int rows = grid.length, cols = grid[0].length;
        boolean[][] visit = new boolean[rows][cols];
        Queue<int[]> q = new LinkedList<>();
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        for(int r = 0 ; r < rows ; r++){
            for(int c = 0 ; c < cols; c++){
                if(grid[r][c] == 0){
                    q.add(new int[]{r,c});
                    visit[r][c] = true;
                }
            }
        }

        int dist = 0;
        
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i < size; i++){
                int[] cur = q.poll();
                grid[cur[0]][cur[1]] = dist;

                for(int[] dir : directions){
                    addToQueue(grid, dir[0] + cur[0], dir[1] + cur[1], q, visit);
                }
            }
            dist++;
        }
    }
    public void addToQueue(int[][] grid, int r, int c, Queue<int[]> q, boolean[][] visit){
        if(r < 0 || c  < 0 || r >= grid.length || c >= grid[0].length || visit[r][c] == true || grid[r][c] == -1){
            return;
        }
        q.add(new int[]{r,c});
        visit[r][c] = true;
    }
}
