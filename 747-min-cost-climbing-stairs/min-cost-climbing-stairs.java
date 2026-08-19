class Solution {
    Map<Integer, Integer> memo = new HashMap<>();

    public int minCostClimbingStairs(int[] cost) {
        return dp(cost.length, cost);
    }

    public int dp(int stair, int[] cost) {
        if (stair <= 1) {
            return 0;
        }

        if (memo.containsKey(stair)) {
            return memo.get(stair);
        }

        memo.put(stair, Math.min(dp(stair - 2, cost) + cost[stair - 2], dp(stair - 1, cost) + cost[stair - 1]));
        return memo.get(stair);
    }
}