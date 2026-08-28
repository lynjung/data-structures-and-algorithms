class Solution {
    public int maxValueOfCoins(List<List<Integer>> piles, int k) {
        int n = piles.size();
        int[][] dp = new int[n + 1][k + 1];

        for (int i = n - 1; i >= 0; i--) {
            for (int remain = 1; remain <= k; remain++) {

                // skip this pile, will later see if taking coins is better
                dp[i][remain] = dp[i + 1][remain];

                // total value of coins we have taken from curr pile
                int curr = 0;

                // j is index; until min of remain & curr pile coin #
                for (int j = 0; j < Math.min(remain, piles.get(i).size()); j++) {
                    curr += piles.get(i).get(j);

                    // curr coins value + best value i can get from later piles
                    dp[i][remain] = Math.max(dp[i][remain], curr + dp[i + 1][remain - j - 1]);
                }
            }
        }

        return dp[0][k];
    }
}