class Solution {
    public int maxProfit(int[] prices) {
        int buy = 0, maxP = 0;
        for(int sell = 1; sell < prices.length;sell++){
            maxP = Math.max(maxP, prices[sell] - prices[buy]);
            if(prices[sell] < prices[buy]){
                buy = sell;
            }
        }
        return maxP;
    }
}
