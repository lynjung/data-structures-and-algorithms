class Solution {
    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        } 

        int withoutLast = robLinear(nums, 0, nums.length - 2);
        int withoutFirst = robLinear(nums, 1, nums.length - 1);

        return Math.max(withoutLast, withoutFirst);
    }

    public int robLinear(int[] nums, int start, int end) {
        int prev2 = 0;
        int prev1 = 0;

        for (int i = start; i <= end; i++) {
            int curr = Math.max(prev1, prev2 + nums[i]);

            prev2 = prev1;
            prev1 = curr;
        }

        return prev1;
    }
}