class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        buy = max_p = 0
        for sell in range(1, len(prices)):
            max_p = max(max_p, prices[sell] - prices[buy])
            if prices[buy] > prices[sell]:
                buy = sell
                sell = buy + 1
        return max_p