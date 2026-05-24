class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> counts = new HashMap<>(); // maps prefix sums to how often they occur
        counts.put(0, 1);

        int sumSoFar = 0;
        int ans = 0;

        for (int num : nums) {
            sumSoFar += num;
            if (counts.containsKey(sumSoFar - k)) {
                ans += counts.get(sumSoFar - k);
            }
            counts.put(sumSoFar, counts.getOrDefault(sumSoFar, 0) + 1);
        }
        return ans;
    }
}