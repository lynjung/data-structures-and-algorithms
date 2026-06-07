class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {

        ArrayDeque<Integer> queue = new ArrayDeque<>();
        int[] ans = new int[nums.length - k + 1];

        for (int i = 0; i < nums.length; i++) {
            // maintain monotonic decreasing
            while (!queue.isEmpty() && nums[i] > nums[queue.getLast()]) {
                queue.removeLast();
            }
            queue.addLast(i);

            // remove the max element if outside the window
            if (queue.getFirst() + k == i) {
                queue.removeFirst();
            }

            // add to ans once window has reached size k
            if (i >= k - 1) {
                ans[i - k + 1] = nums[queue.getFirst()];
            }
        }
        return ans;
    }
}