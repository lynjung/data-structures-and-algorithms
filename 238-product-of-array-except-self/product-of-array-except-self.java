class Solution {
    public int[] productExceptSelf(int[] nums) {

        int[] answer = new int[nums.length];
        answer[0] = 1;
        int prefix = 1;
        int postfix = 1;

        for (int i = 0; i < nums.length; i++) {
            answer[i] = prefix;
            prefix *= nums[i];
        }

        for (int i = nums.length - 1; i > -1; i--) {
            answer[i] *= postfix;
            postfix *= nums[i];
        }

        return answer;
    }
}