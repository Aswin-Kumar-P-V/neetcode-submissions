class Solution:
    def leastInterval(self, tasks: List[str], n: int) -> int:
        count = Counter(tasks)
        max_heap = []
        for freq in count.values():
            heapq.heappush(max_heap, -freq)
        q = deque()
        time = 0
        while max_heap or q:
            time += 1
            if max_heap:
                freq = 1 + heapq.heappop(max_heap)
                if freq:
                    q.append([freq, time + n])
            if q and q[0][1] == time:
                freq, time = q.popleft()
                heapq.heappush(max_heap, freq)
        return time