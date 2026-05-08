class Solution {
    public int maxProfit(int[] prices) {
        int sell = 0;
        int profit = 0;
        for(int buy = sell + 1; buy < prices.length; buy++){
            if(prices[buy] < prices[sell]){
                sell = buy;
            }else{
                profit = Math.max(profit, prices[buy] - prices[sell]);
            }
        }
        return profit;
    }
}
