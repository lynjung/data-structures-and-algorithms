class Solution {
    public int minSetSize(int[] arr) {
        int size = arr.length;
        int ans = 0;

        Map<Integer, Integer> counts = new HashMap<>();
        for (int num : arr) {
            counts.put(num, counts.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<Integer> maxheap = new PriorityQueue<>(Comparator.reverseOrder());
        for (int count : counts.values()) {
            maxheap.add(count);
        }

        while (size > arr.length / 2) {
            size -= maxheap.remove();
            ans++;
        }

        return ans;
    }
}