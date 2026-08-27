class Solution {
    int m;
    int n;
    int[][] memo;
    String text1;
    String text2;

    public int longestCommonSubsequence(String text1, String text2) {
        m = text1.length();
        n = text2.length();
        this.text1 = text1;
        this.text2 = text2;
        memo = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(memo[i], -1);
        }

        return dp(0, 0);
    }

    public int dp(int i, int j) {
        if (i == m || j == n) {
            return 0;
        }

        if (memo[i][j] != -1) {
            return memo[i][j];
        }

        int ans = 0;
        if (text1.charAt(i) == text2.charAt(j)) {
            ans = 1 + dp(i + 1, j + 1);
        } else {
            ans = Math.max(dp(i + 1, j), dp(i, j + 1));
        }

        memo[i][j] = ans;
        return ans;
    }
}