class Solution {
    public int removeDuplicates(int[] nums) {
        
        int slo = 1;
        
        for (int fast = 1; fast < nums.length; fast++) {
            if (nums[fast] != nums[fast - 1]) {
                nums[slo] = nums[fast];
                slo++;
            }
        }
        return slo;
    }
}