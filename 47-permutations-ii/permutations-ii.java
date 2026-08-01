class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);

        boolean[] used = new boolean[nums.length];
        List<List<Integer>> ans = new ArrayList<>();

        backtrack(new ArrayList<>(), used, ans, nums);
        return ans;
    }

    private void backtrack(List<Integer> curr, boolean[] used, List<List<Integer>> ans, int[] nums) {
        if (curr.size() == nums.length) {
            ans.add(new ArrayList<>(curr));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }

            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                continue;
            }

            curr.add(nums[i]);
            used[i] = true;

            backtrack(curr, used, ans, nums);
            used[i] = false;
            curr.remove(curr.size() - 1);
        }
    }
}