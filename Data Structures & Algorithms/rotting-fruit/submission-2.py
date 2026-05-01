class Solution:
    def orangesRotting(self, grid: List[List[int]]) -> int:
        rows,cols = len(grid),len(grid[0])
        fresh = time = 0
        visited = set()
        q = deque()
        for r in range(rows):
            for c in range(cols):
                if grid[r][c] == 2:
                    q.append([r,c])
                    visited.add((r,c))
                elif grid[r][c] == 1:
                    fresh += 1
        def addfruit(r,c):
            nonlocal fresh
            if r < 0 or c < 0 or r>= rows or c >= cols or (r,c) in visited or grid[r][c] == 0:
                return
            fresh -= 1
            q.append([r,c])
            visited.add((r,c))
        while q and fresh>0:
            time += 1
            l = len(q)
            for i in range(l):
                r,c=q.popleft()
                grid[r][c] = 2
                
                addfruit(r+1,c)
                addfruit(r-1,c)
                addfruit(r,c+1)
                addfruit(r,c-1)
            
        if fresh: return -1
        return time
        