class Solution {
    public List<Integer> intersection(int[][] nums) {
        Map<Integer, Integer> counts = new HashMap<>();

        for (int[] array : nums) {
            for (int x : array) {
                counts.put(x, counts.getOrDefault(x, 0) + 1);
            }
        }

        List<Integer> ans = new ArrayList<>();
        
        for (int key : counts.keySet()) {
            if (counts.get(key) == nums.length) {
                ans.add(key);
            }
        }
        
        Collections.sort(ans);
        return ans;
    }
}