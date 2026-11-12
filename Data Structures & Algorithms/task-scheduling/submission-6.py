class Solution:
    def leastInterval(self, tasks: List[str], n: int) -> int:
        count = Counter(tasks)
        heap = [-i for i in count.values()]
        heapq.heapify(heap)
        q = deque()
        time = 0
        while heap or q:
            time += 1
            if heap:
                task = 1 + heapq.heappop(heap)
                if task:
                    q.append([task, time + n])
            if q and q[0][1] == time:
                node = q.popleft()
                heapq.heappush(heap, node[0])
        return time