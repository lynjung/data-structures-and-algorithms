class Solution {
    public int[] twoSum(int[] nums, int target) {
        
        HashMap<Integer, Integer> hashmap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int com = target - nums[i];
            if (hashmap.containsKey(com)) {
                return new int[] {hashmap.get(com), i};
            }
            hashmap.put(nums[i], i);
        }
        return new int[] {0,1};
    }
}