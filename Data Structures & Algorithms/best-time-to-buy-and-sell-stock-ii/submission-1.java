class Solution {
    public int maxProfit(int[] prices) {
        int max = 0, buy = 0;
        for(int sell = buy + 1; sell < prices.length; sell++){
            int profit = prices[sell] - prices[buy];
            max += profit > 0 ? profit : 0;
            buy = sell;
        }
        return max;
    }
}