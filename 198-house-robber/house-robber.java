class Solution {
    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }

        int backTwo = nums[0];
        int backOne = Math.max(nums[0], nums[1]);

        for (int i = 2; i < nums.length; i++) {
            int temp = backOne;
            backOne = Math.max(backTwo + nums[i], backOne);
            backTwo = temp;
        }

        return backOne;
    }
}