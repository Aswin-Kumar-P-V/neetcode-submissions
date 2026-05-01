class Solution:
    def lastStoneWeight(self, stones: List[int]) -> int:
        for i in range(len(stones)):
            stones[i] *= -1
        heapq.heapify(stones)
        while len(stones) > 1:
            a = heapq.heappop(stones) - heapq.heappop(stones)
            heapq.heappush(stones,a)
        return -stones[0]