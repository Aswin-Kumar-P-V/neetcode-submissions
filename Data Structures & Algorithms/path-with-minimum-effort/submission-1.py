class Solution:
    def minimumEffortPath(self, heights: List[List[int]]) -> int:
        rows, cols = len(heights), len(heights[0])
        visited = set()
        minHeap =[[0,0,0]]
        directions = [[1,0], [-1, 0], [0, 1], [0,-1]]
        while minHeap:
            diff, r, c = heapq.heappop(minHeap)
            if (r, c) in visited:
                continue
            if (r, c) == (rows -1, cols - 1):
                return diff
            visited.add((r,c))

            for rd, cd in directions:
                newr, newc = r + rd, c + cd
                if newr < 0 or newc < 0 or newr == rows or newc == cols or (newr, newc) in visited:
                    continue
                
                newDiff = max(diff, abs(heights[r][c] - heights[newr][newc]))
                heapq.heappush(minHeap, [newDiff, newr, newc])