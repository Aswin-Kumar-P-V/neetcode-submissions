class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        buy, sell = 0, 1
        max_profit = 0
        while sell < len(prices):
            current_profit = prices[sell] - prices[buy]
            max_profit = max(max_profit, current_profit)
            if prices[sell] < prices[buy]:
                buy = sell
                sell = buy + 1
                continue
            sell += 1
        return max_profit