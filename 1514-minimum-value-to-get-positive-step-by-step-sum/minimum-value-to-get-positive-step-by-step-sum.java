class Solution {
    public int minStartValue(int[] nums) {
        int[] prefix = new int[nums.length];
        prefix[0] = nums[0];
        int min = prefix[0];

        for (int i = 1; i < nums.length; i++) {
            prefix[i] = prefix[i - 1] + nums[i];
            min = Math.min(min, prefix[i]);
        }

        // min + startValue = 1
        if (min >= 1) return 1;
        
        return 1 - min;
    }
}