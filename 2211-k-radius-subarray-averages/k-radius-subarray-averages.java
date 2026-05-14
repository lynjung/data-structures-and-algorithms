class Solution {
    public int[] getAverages(int[] nums, int k) {
        int n = nums.length;
        long[] prefix = new long[n];
        prefix[0] = nums[0];

        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] + nums[i];
        }

        int[] avgs = new int[n];

        for (int i = 0; i < n; i++) {
            if (i < k || i > n - k - 1) {
                avgs[i] = -1;
            }
            else {
                long sum = prefix[i + k] - prefix[i - k] + nums[i - k];
                avgs[i] = (int) (sum / (2 * k + 1));
            }
        }
        return avgs;
    }
}