class Solution {
    public int maxProfit(int[] prices) {
        int maxprofit = 0;
        int buy = 0;
        for(int sell = buy + 1; sell < prices.length;sell++){
            int currProfit = prices[sell] - prices[buy];
            maxprofit = Math.max(maxprofit, currProfit);
            if(currProfit < 0){
                buy = sell;
            }
        }
        return maxprofit;
    }
}
