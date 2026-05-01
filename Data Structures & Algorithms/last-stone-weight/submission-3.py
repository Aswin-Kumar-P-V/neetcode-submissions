class Solution:
    def lastStoneWeight(self, stones: List[int]) -> int:
        heap = []
        for stone in stones:
            heapq.heappush(heap, -stone)
        
        while len(heap) > 1:
            a = heapq.heappop(heap) - heapq.heappop(heap)
            heapq.heappush(heap,a)
        return -heap[0]
        