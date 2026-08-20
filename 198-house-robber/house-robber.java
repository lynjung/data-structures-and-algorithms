class Solution {
    Map<Integer, Integer> memo = new HashMap<>();

    public int rob(int[] nums) {
        return dp(nums.length - 1, nums);
    }

    public int dp(int i, int[] nums) {
        if (i == 0) {
            return nums[i];
        }
        if (i == 1) {
            return Math.max(nums[0], nums[1]);
        }

        if (memo.containsKey(i)) {
            return memo.get(i);
        }

        memo.put(i, Math.max(dp(i - 2, nums) + nums[i], dp(i - 1, nums)));
        return memo.get(i);
    }
}