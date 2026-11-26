class Solution:
    def maxAreaOfIsland(self, grid: List[List[int]]) -> int:
        dir = [[-1, 0], [1, 0], [0, -1], [0, 1]]   
        row, col = len(grid), len(grid[0])
        area = 0
        self.current = 0

        def dfs(r, c):
            if r < 0 or c < 0 or r >= len(grid) or c >= len(grid[0]) or grid[r][c] == 0:
                return
            self.current += 1
            grid[r][c] = 0

            for d in dir:
                dfs(r + d[0], c + d[1])
            
        for r in range(row):
            for c in range(col):
                if grid[r][c] == 1:
                    self.current = 0
                    dfs(r, c)
                    area = max(area, self.current)
        return area