class Solution:
    def minimumEffortPath(self, heights: List[List[int]]) -> int:
        rows, cols = len(heights), len(heights[0])
        minHeap = [[0,0,0]]
        visited = set()
        directions = [[1, 0], [-1, 0], [0, 1], [0, -1]]
        while minHeap:
            diff, r, c = heapq.heappop(minHeap)
            if (r, c) in visited:
                continue
            
            visited.add((r, c))
            
            if r == rows - 1 and c == cols - 1:
                return diff

            for rd, cd in directions:
                newr, newc = r + rd, c + cd
                if newr < 0 or newc < 0 or newr == rows or newc == cols or (newr, newc) in visited:
                    continue
                newDiff = abs(heights[newr][newc] - heights[r][c])
                heapq.heappush(minHeap, [max(newDiff, diff), newr, newc])