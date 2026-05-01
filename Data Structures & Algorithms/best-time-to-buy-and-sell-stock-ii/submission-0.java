class Solution {
    public int maxProfit(int[] prices) {
        int max = 0;
        int buy = 0;
        for(int sell = buy + 1; sell < prices.length; sell++){
            int profit = prices[sell] - prices[buy];
            if(profit > 0){
                max += profit;
                buy = sell;
            }else{
                buy = sell;
            }
        }
        return max;
    }
}