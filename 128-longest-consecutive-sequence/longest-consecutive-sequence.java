class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return 1;
        }
        
        Arrays.sort(nums);
        int max = 1;
        int ans = 1;

        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] + 1 == nums[i + 1]) {
            max++;
            ans = Math.max(ans, max);
            } else if (nums[i] == nums[i + 1]) {
                continue;
            } else {
                max = 1;
            }
        }
        return ans;
    }
}