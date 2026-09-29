class Solution {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int maxA = 0;

        while (left < right) {
            int l = Math.min(height[left], height[right]);
            int w = right - left;
            maxA = Math.max(maxA, l * w);
            if (l == height[left]) {
                left++;
            } else {
                right--;
            }
        }
        return maxA;
    }
}