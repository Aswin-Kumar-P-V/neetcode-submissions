class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        buy = max_profit = 0
        for sell in range(len(prices)):
            profit = prices[sell] - prices[buy]
            max_profit = max(max_profit, profit)
            if prices[buy] > prices[sell]:
                buy = sell
                sell = buy + 1
        return max_profit