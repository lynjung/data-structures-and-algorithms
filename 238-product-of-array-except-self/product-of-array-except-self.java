class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        ans[0] = 1;

        int pre = 1;
        for (int i = 1; i < n; i++) {
            pre *= nums[i - 1];
            ans[i] = pre;
        }

        int post = 1;
        for (int i = n - 2; i >= 0; i--) {
            post *= nums[i + 1];
            ans[i] *= post;
        }
        return ans;
    }
}