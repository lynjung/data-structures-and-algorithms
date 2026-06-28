class Solution {
    public double findMaxAverage(int[] nums, int k) {
        double sum = 0;

        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }

        double avg = (double) sum / k;
        double max = avg;
        int left = 0;
        
        for (int right = k; right < nums.length; right++) {
            sum += nums[right] - nums[left];
            avg = (double) sum / k;
            max = Math.max(max, avg);
            left++;
        }

        return max;
    }
}