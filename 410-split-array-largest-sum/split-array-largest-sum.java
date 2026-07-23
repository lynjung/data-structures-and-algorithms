class Solution {
    public int splitArray(int[] nums, int k) {
        int left = 0;
        int right = 0;

        for (int num : nums) {
            left = Math.max(left, num);
            right += num;
        }

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (check(mid, nums, k)) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    public boolean check(int mid, int[] nums, int k) {
        int subs = 1;
        int subSum = 0;

        for (int num : nums) {
            if ((subSum + num) > mid) {
                subs++;
                subSum = 0;
            }

            subSum += num;
        }        

        return subs <= k;
    }
}