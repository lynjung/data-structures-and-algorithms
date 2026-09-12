class Solution {
    public int maxProfit(int[] prices) {
        int left = 0;
        int right = 1;
        int ans = 0;

        while (right < prices.length) {
            if (prices[left] < prices[right]) {
                int profit = prices[right] - prices[left];
                ans = Math.max(ans, profit);
            } else {
                left = right;
            }
            right++;
        }

        return ans;
    }
}