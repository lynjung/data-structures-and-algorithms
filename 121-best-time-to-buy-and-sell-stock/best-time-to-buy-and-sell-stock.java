class Solution {
    public int maxProfit(int[] prices) {
        
        int buyPrice = 0;
        int sellPrice = 1;
        int maxProfit = 0;

        for (int i = 0; i < prices.length - 1; i++) {
            int profit = prices[sellPrice] - prices[buyPrice];
            maxProfit = Math.max(maxProfit, profit);

            if (prices[buyPrice] > prices[sellPrice]) {
                buyPrice = sellPrice;
            }
            sellPrice++;
        }
        return maxProfit;
    }
}