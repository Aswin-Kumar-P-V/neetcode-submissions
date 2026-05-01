class Solution:
    def leastInterval(self, tasks: List[str], n: int) -> int:
        freq_map = defaultdict(int)
        for task in tasks:
            freq_map[task] += 1
        freq = [-cnt for cnt in freq_map.values()]
        heapq.heapify(freq)
        q = deque()
        time = 0
        while freq or q:
            time += 1
            if freq:
                cnt = heapq.heappop(freq) + 1
                if cnt < 0:
                    q.append([cnt, time + n])
            if q and q[0][1] == time:
                heapq.heappush(freq,q.popleft()[0])
        return time
