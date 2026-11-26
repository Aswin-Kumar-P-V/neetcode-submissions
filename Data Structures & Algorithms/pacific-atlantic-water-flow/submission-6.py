class Solution:
    def pacificAtlantic(self, heights: List[List[int]]) -> List[List[int]]:
        rows, cols = len(heights), len(heights[0])
        pac = set()
        atl = set()
        directions = [[1, 0], [-1, 0], [0, 1], [0, -1]]

        def dfs(r, c, visited, prev):
            if r < 0 or c < 0 or r >= len(heights) or c >= len(heights[0]) or (r, c) in visited or heights[r][c] < prev:
                return
            visited.add((r, c))
            for rd, cd in directions:
                dfs(r + rd, c + cd, visited, heights[r][c])
        
        for c in range(cols):
            dfs(0, c, pac, heights[0][c])
            dfs(rows - 1, c, atl, heights[rows - 1][c])
        
        for r in range(rows):
            dfs(r, 0, pac, heights[r][0])
            dfs(r, cols - 1, atl, heights[r][cols - 1])
        
        res = []

        for r in range(rows):
            for c in range(cols):
                if (r, c) in pac and (r, c) in atl:
                    res.append([r, c])
        
        return res