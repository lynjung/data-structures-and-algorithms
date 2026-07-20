class Solution {
    public int[] answerQueries(int[] nums, int[] queries) {
        Arrays.sort(nums);

        for (int i = 1; i < nums.length; i++) {
            nums[i] += nums[i - 1];
        }

        int[] ans = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            ans[i] = binarySearch(nums, queries[i]);
        }

        return ans;
    }

    public int binarySearch(int[] prefix, int target) {
        int left = 0;
        int right = prefix.length;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (prefix[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }
}