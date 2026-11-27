class Solution:
    def islandsAndTreasure(self, grid: List[List[int]]) -> None:
        rows, cols = len(grid), len(grid[0])
        q = deque()
        visited = set()

        for r in range(rows):
            for c in range(cols):
                if grid[r][c] == 0:
                    q.append([r, c])
                    visited.add((r, c))
        
        def addRoom(r, c):
            if r < 0 or c < 0 or r >= len(grid) or c >= len(grid[0]) or (r, c) in visited or grid[r][c] == -1:
                return
            q.append([r, c])
            visited.add((r, c))
        
        directions = [[1, 0], [-1, 0], [0, 1], [0, -1]]
        distance = 0

        while q:
            l = len(q)
            for i in range(l):
                r, c = q.popleft()
                grid[r][c] = distance
                for rd, cd in directions:
                    addRoom(r + rd, c + cd)
            distance += 1
        