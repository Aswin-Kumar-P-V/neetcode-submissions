class Solution {
    
    public int orangesRotting(int[][] grid) {
        int[][] dir = {{1,0}, {-1,0}, {0, 1}, {0, -1}};
        int rows = grid.length, cols = grid[0].length, time = 0, fresh = 0;
        Queue<int[]> q = new LinkedList<>();
        for(int r = 0; r< rows;r++){
            for(int c = 0; c< cols;c++){
                if(grid[r][c] == 1){
                    fresh++;
                }else if(grid[r][c] == 2){
                    q.add(new int[]{r,c});
                }
            }
        }
        while(!q.isEmpty() && fresh > 0){
            int size = q.size();
            for(int i = 0; i < size; i++){
                int[] temp = q.poll();
                for(int[] d : dir){
                    int r = temp[0] + d[0], c = temp[1] + d[1];
                    if(r < 0 || c < 0 || r >= grid.length || c >= grid[0].length || grid[r][c] != 1){
                        continue;
                    }
                    grid[r][c] = 2;
                    q.add(new int[]{r,c});
                    fresh--;
                }
            }
            time++;
        }
        return fresh == 0 ? time : -1;
    }

}
