class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>(Comparator.reverseOrder());
        for (int num : nums) {
            heap.add(num);
        }

        int ans = 0;
        for (int i = 0; i < k; i++) {
            ans = heap.remove();
        }

        return ans;
    }
}