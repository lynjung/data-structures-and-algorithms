class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashSet<Integer> hashset = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            if (hashset.contains(nums[i])) {
                return true;
            }

            hashset.add(nums[i]);

            if (hashset.size() > k) {
                hashset.remove(nums[i - k]);
            }
        }
        return false;
    }
}