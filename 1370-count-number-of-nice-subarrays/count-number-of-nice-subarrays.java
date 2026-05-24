class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        Map<Integer, Integer> counts = new HashMap<>();
        counts.put(0, 1);

        int curr = 0;
        int ans = 0;

        for (int num : nums) {
            curr += num % 2;
            if (counts.containsKey(curr - k)) {
                ans += counts.get(curr - k);
            }
            counts.put(curr, counts.getOrDefault(curr, 0) + 1);
        }
        return ans;
    }
}