class Solution {
    public int halveArray(int[] nums) {
        PriorityQueue<Double> heap = new PriorityQueue<>(Comparator.reverseOrder());
        double target = 0;
        
        for (double num : nums) {  
            target += num;
            heap.add(num);
        }

        target /= 2;
        int ans = 0;

        while (target > 0) {
            double x = heap.remove();
            target -= (x / 2);
            ans++;
            heap.add(x / 2);
        }
        return ans;
    }
}