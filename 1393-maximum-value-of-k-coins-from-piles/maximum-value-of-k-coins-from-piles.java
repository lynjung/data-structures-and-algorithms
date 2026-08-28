class Solution {
    int n;
    int[][] memo;
    List<List<Integer>> piles;
    
    public int maxValueOfCoins(List<List<Integer>> piles, int k) {
        n = piles.size();
        memo = new int[n][k + 1];
        for (int i = 0; i < n; i++) {
            Arrays.fill(memo[i], -1);
        }
        
        this.piles = piles;
        return dp(0, k);
    }
    
    public int dp(int i, int remain) {
        if (i == n || remain == 0) {
            return 0;
        }
        
        if (memo[i][remain] != -1) {
            return memo[i][remain];
        }
        
        int ans = dp(i + 1, remain);
        int curr = 0;
        for (int j = 0; j < Math.min(remain, piles.get(i).size()); j++) {
            curr += piles.get(i).get(j);
            ans = Math.max(ans, curr + dp(i + 1, remain - j - 1));
        }
        
        memo[i][remain] = ans;
        return ans;
    }
}