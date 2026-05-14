class Solution {
    public int waysToSplitArray(int[] nums) {
        // sum of int's can be way too large
        long leftSum = 0;
        long totSum = 0;
        int ans = 0;

        for (int num : nums) {
            totSum += num;
        }

        for (int i = 0; i < nums.length - 1; i++) {
            leftSum += nums[i];
            long rightSum = totSum - leftSum;
            if (leftSum >= rightSum) {
                ans++;
            }
        }
        return ans;
    }
}