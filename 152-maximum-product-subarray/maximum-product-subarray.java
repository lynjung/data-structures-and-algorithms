class Solution {
    public int maxProduct(int[] nums) {
        int curMax = nums[0];
        int curMin = nums[0];
        int ans = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int temp = curMax * nums[i];
            curMax = Math.max(nums[i], Math.max(temp, curMin * nums[i]));
            curMin = Math.min(nums[i], Math.min(temp, curMin * nums[i]));
            ans = Math.max(ans, curMax);
        }

        return ans;
    }
}