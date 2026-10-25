class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        buy = 0
        maxprofit = 0
        for sell in range(1, len(prices)):
            currprofit = prices[sell] - prices[buy]
            if currprofit > 0:
                maxprofit = max(currprofit, maxprofit)
            else:
                buy = sell
        return maxprofit
        