class Solution:
    def findCheapestPrice(self, n: int, flights: List[List[int]], src: int, dst: int, k: int) -> int:
        prices = [float("inf")] * n
        prices[src] = 0

        for i in range(k + 1):
            tempPrices = prices.copy()

            for s, t, p in flights:
                if prices[s] == float("inf"):
                    continue
                if prices[s] + p < tempPrices[t]:
                    tempPrices[t] = prices[s] + p
            prices = tempPrices
        
        return -1 if prices[dst] == float("inf") else prices[dst]