class Solution {
    public int maxArea(int[] height) {
        
        int max = 0;
        int left = 0;
        int right = height.length - 1;

        for (int i = 0; i < height.length; i++) {
            int area = (right - left) * Math.min(height[left], height[right]);
            max = Math.max(max, area);

            if (height[left] < height[right]) {
                left++;
            }
            else {
                right--;
            }
        }
        return max;
    }
}