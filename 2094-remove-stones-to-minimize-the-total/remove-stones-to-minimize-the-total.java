class Solution {
    public int minStoneSum(int[] piles, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue(Comparator.reverseOrder());
        for (int i = 0; i < piles.length; i++) {
            heap.add(piles[i]);
        }

        for (int i = 0; i < k; i++) {
            int stones = heap.remove();
            heap.add(stones - stones / 2);
        }

        int sum = 0;
        for (int stone : heap) {
            sum += stone;
        }
        return sum;
    }
}