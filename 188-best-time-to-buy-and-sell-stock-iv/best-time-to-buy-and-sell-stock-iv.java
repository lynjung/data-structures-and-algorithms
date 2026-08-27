class Solution {
    public int maxProfit(int k, int[] prices) {
        int[][][] dp = new int[prices.length + 1][2][k + 1];

        for (int i = prices.length - 1; i >= 0; i--) {
            for (int remain = 1; remain <= k; remain++) {
                for (int holding = 0; holding < 2; holding++) {
                    int ans = dp[i + 1][holding][remain]; // assume i skip today
                    
                    if (holding == 1) { // if i'm holding,
                        // maybe selling is better
                        ans = Math.max(ans, prices[i] + dp[i + 1][0][remain - 1]);
                    } else { // if i'm not holding,
                        // maybe buying is better
                        ans = Math.max(ans, -prices[i] + dp[i + 1][1][remain]);
                    }
                    dp[i][holding][remain] = ans;
                }
            }
        }

        return dp[0][0][k];
    }
}