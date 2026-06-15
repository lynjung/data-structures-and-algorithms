class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> heap = new PriorityQueue<>((p1, p2) -> {
            int dist1 = p1[0] * p1[0] + p1[1] * p1[1];
            int dist2 = p2[0] * p2[0] + p2[1] * p2[1];

            return dist2 - dist1; // max heap by distance
        });

        for (int[] point : points) {
            heap.add(point);
            if (heap.size() > k) {
                heap.remove();
            }
        }

        int[][] ans = new int[k][2];
        for (int i = 0; i < k; i++) {
            ans[i] = heap.remove();
        }
        return ans;
    }
}