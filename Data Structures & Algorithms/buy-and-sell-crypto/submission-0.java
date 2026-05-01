class Solution {
    public int maxProfit(int[] prices) {
        int buy = 0, sell = 1, maxProfit = 0;
        while(sell < prices.length){
            if(prices[sell] < prices[buy]){
                buy = sell;
            }else{
                maxProfit = Math.max(maxProfit, prices[sell] - prices[buy]);
            }
            sell++;
        }
        return maxProfit;
    }
}
