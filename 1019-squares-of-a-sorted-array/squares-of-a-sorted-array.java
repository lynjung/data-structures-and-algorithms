class Solution {
    public int[] sortedSquares(int[] nums) {
        int[] ans = new int[nums.length];
        int left = 0;
        int right = nums.length - 1;
        int i = nums.length - 1;

        while (left <= right) {
            int leftsq = nums[left] * nums[left];
            int rightsq = nums[right] * nums[right];

            if (leftsq >= rightsq) {
                ans[i] = leftsq;
            }
            else {
                ans[i] = rightsq;
            }

            if (ans[i] == leftsq) {
                left++;
            }
            else {
                right--;
            }
            i--;
        }
        return ans;
    }
}