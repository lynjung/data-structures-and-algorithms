class Solution {
    public int longestOnes(int[] nums, int k) {
        // basically find the max length subarray that has less than or equal to k 0's

        int left = 0;
        int zeros = 0;
        int length = 0;

        for (int right = 0; right < nums.length; right++) {
            if (nums[right] == 0) {
                zeros++;
            }
            while (zeros > k) {
                if (nums[left] == 0) {
                    zeros--;
                }
                left++;
            }
            length = Math.max(length, right - left + 1);
        }
        return length;
    }
}