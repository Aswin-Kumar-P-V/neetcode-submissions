class Solution:
    def orangesRotting(self, grid: List[List[int]]) -> int:
        rows, cols = len(grid), len(grid[0])
        fresh = 0
        directions = [[-1, 0], [0, -1], [0, 1], [1, 0]]
        q = deque()
        visited = set()

        for r in range(rows):
            for c in range(cols):
                if grid[r][c] == 2:
                    q.append([r, c])
                    visited.add((r , c))
                elif grid[r][c] == 1:
                    fresh += 1
        
        def addFruit(r, c):
            nonlocal fresh
            if r < 0 or c < 0 or r >= len(grid) or c >= len(grid[0]) or (r, c) in visited or grid[r][c] == 0:
                return
            fresh -= 1
            q.append([r, c])
            visited.add((r, c))
        time = 0
        while q and fresh > 0:
            l = len(q)
            time += 1
            for i in range(l):
                r, c = q.popleft()
                grid[r][c] = 2
                for rd, cd in directions:
                    addFruit(r + rd, c + cd)
        return -1 if fresh else time