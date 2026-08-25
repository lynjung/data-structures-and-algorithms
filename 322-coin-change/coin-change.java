class Solution {
    Map<Integer, Integer> memo = new HashMap<>();

    public int coinChange(int[] coins, int amount) {
        return dp(coins, amount);
    }

    public int dp(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        if (amount < 0) {
            return -1;
        }

        if (memo.containsKey(amount)) {
            return memo.get(amount);
        }

        int min = Integer.MAX_VALUE;

        for (int i = 0; i < coins.length; i++) {
            int result = dp(coins, amount - coins[i]);
            if (result != -1) {
                min = Math.min(min, 1 + result);
            }
        }

        if (min == Integer.MAX_VALUE) {
            memo.put(amount, -1);
        } else {
            memo.put(amount, min);
        }

        return memo.get(amount);
    }
}