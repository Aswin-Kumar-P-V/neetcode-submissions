class Solution:
    def networkDelayTime(self, times: List[List[int]], n: int, k: int) -> int:
        adjList = defaultdict(list)

        for s, t, w in times:
            adjList[s].append([t, w])
        
        min_heap = [[0, k]]
        visited = set()
        t = 0
        while min_heap:
            w1, n1 = heapq.heappop(min_heap)
            if n1 in visited:
                continue
            visited.add(n1)
            t = max(0, w1)

            for neigh, weight in adjList[n1]:
                if neigh not in visited:
                    heapq.heappush(min_heap, [w1 + weight, neigh])
        return t if n == len(visited) else -1
