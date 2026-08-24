class Solution {
    Map<Integer, Integer> memo = new HashMap<>();

    public int climbStairs(int n) {
        return dp(n);
    }

    public int dp(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }

        if (memo.containsKey(n)) {
            return memo.get(n);
        }
        memo.put(n, dp(n - 2) + dp(n - 1));
        return memo.get(n);
    }
}