class Solution:
    def networkDelayTime(self, times: List[List[int]], n: int, k: int) -> int:
        min_heap = [(0, k)]
        adjList = defaultdict(list)
        for s, t, w in times:
            adjList[s].append((t, w))
        visited = set()
        t = 0
        while min_heap:
            w, n1 = heapq.heappop(min_heap)
            if n1 in visited:
                continue
            visited.add(n1)
            t = max(t, w)
            for neigh, weight in adjList[n1]:
                if neigh not in visited:
                    heapq.heappush(min_heap, [w + weight, neigh]) 
        
        return t if n == len(visited) else -1