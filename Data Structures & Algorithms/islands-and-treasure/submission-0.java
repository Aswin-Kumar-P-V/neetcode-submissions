class Solution {
    public void islandsAndTreasure(int[][] grid) {
        int[][] directions = {{1,0}, {0,1}, {-1,0}, {0,-1}};
        int rows = grid.length, cols = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visit = new boolean[rows][cols];
        int dist = 0;

        for(int r = 0 ; r < rows; r++){
            for(int c = 0 ; c < cols; c++){
                if(grid[r][c] == 0){
                    q.add(new int[]{r,c});
                    visit[r][c] = true;
                }
            }
        }

        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i < size; i++){
                int[] temp = q.poll();
                grid[temp[0]][temp[1]] = dist;

                for(int[] dir : directions){
                    addToQueue(grid, temp[0] + dir[0], temp[1] + dir[1], q, visit);
                }
            }
            dist++;
        }
    }
    public void addToQueue(int[][] grid, int r, int c, Queue<int[]> q, boolean[][] visit){
        if(r < 0 || c < 0 || r >= grid.length || c >= grid[0].length || grid[r][c] == -1 || visit[r][c] == true){
            return;
        }
        q.add(new int[]{r,c});
        visit[r][c] = true;
    }
}
