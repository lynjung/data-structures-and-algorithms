class Solution {
    public int maxProfit(int[] prices) {
        
        int buyPrice = prices[0];
        int maxProfit = 0;

        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > buyPrice) {
                int profit = prices[i] - buyPrice;
                maxProfit = Math.max(maxProfit, profit);
            }
            else {
                buyPrice = prices[i];
            }
        }
        return maxProfit;
    }
}