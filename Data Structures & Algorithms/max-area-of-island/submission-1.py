class Solution:
    def maxAreaOfIsland(self, grid: List[List[int]]) -> int:
        area = 0
        direction = [[1,0],[-1,0],[0,1],[0,-1]]
        rows,cols = len(grid), len(grid[0])
        self.current = 0
        def dfs(r,c):
            if r < 0 or c < 0 or r >= rows or c >= cols or grid[r][c] == 0:
                return
            grid[r][c] = 0
            self.current += 1
            for rd,cd in direction:
                dfs(r+rd, c+cd)
            
        for r in range(rows):
            for c in range(cols):
                if grid[r][c] == 1:
                    self.current = 0
                    dfs(r,c)
                    area=max(area,self.current)
        return area
        