class Solution {
    public int orangesRotting(int[][] grid) {
        int[][] directions = {{1, 0}, {-1, 0}, {0,1}, {0,-1}};
        int rows = grid.length, cols = grid[0].length, time = 0, fresh = 0;
        Queue<int[]> q = new LinkedList<>();
        
        for(int r = 0; r < rows; r++){
            for(int c = 0; c < cols; c++){
                if(grid[r][c] == 1){
                    fresh++;
                }
                if(grid[r][c] == 2){
                    q.add(new int[]{r, c});
                }
            }
        }

        while (!q.isEmpty() && fresh > 0){
            int size = q.size();
            for(int i = 0; i < size; i++){
                int[] curr = q.poll();
                for(int[] dir :  directions){
                    int r = curr[0] + dir[0], c = curr[1] + dir[1];
                    if(r < 0 || c < 0 || r >= rows || c >= cols || grid[r][c] != 1){
                        continue;
                    }
                    grid[r][c] = 2;
                    q.add(new int[]{r,c});
                    fresh--;
                }
            }
            time++;
        }
        if(fresh == 0) return time;
        return -1;
    }
}
