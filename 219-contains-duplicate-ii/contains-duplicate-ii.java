class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        
        Map<Integer, Integer> hash = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (hash.containsKey(nums[i])) {
                if (Math.abs(hash.get(nums[i]) - i) <= k) {
                    return true;
                }
            }
            hash.put(nums[i], i);
        }
        return false;
    }
}