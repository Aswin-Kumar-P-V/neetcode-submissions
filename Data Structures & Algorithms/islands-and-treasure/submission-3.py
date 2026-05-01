class Solution:
    def islandsAndTreasure(self, grid: List[List[int]]) -> None:
        visited = set()
        q = deque()
        rows, cols = len(grid), len(grid[0])
        for r in range(rows):
            for c in range(cols):
                if grid[r][c] == 0:
                    q.append([r,c])
                    visited.add((r,c))
        def addroom(r,c):
            if r<0 or c < 0 or r >= rows or c >= cols or (r,c) in visited or grid[r][c] == -1:
                return
            visited.add((r,c))
            q.append([r,c])
        distance = 0
        while q:
            l = len(q)
            for i in range(l):
                r, c = q.popleft()
                grid[r][c] = distance
                addroom(r+1,c)
                addroom(r-1,c)
                addroom(r,c+1)
                addroom(r,c-1)
            distance+=1
        