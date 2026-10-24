class Solution:
    def lastStoneWeight(self, stones: List[int]) -> int:
        heap = [-stone for stone in stones]
        heapq.heapify(heap)
        while len(heap) >= 2:
            a = -heapq.heappop(heap)
            b = -heapq.heappop(heap)
            diff = b - a
            if diff != 0:
                heapq.heappush(heap, diff)
        return -heap[0] if heap else 0
        