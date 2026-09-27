class Solution {
    public int maxProfit(int[] prices) {
        int max = 0;
        int buy = 0;
        int sell = 1;

        while (sell < prices.length) {
            if (prices[sell] < prices[buy]) {
                buy = sell;
            } else {
                int profit = prices[sell] - prices[buy];
                max = Math.max(max, profit);
            }
            sell++;
        }
        return max;
    }
}