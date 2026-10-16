class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        buy = 0
        max_profit = 0
        for sell in range(1, len(prices)):
            curr_profit = prices[sell] - prices[buy]
            max_profit = max(max_profit, curr_profit)
            if prices[sell] < prices[buy]:
                buy = sell
        return max_profit