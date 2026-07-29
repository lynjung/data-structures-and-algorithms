class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        backtrack(new ArrayList<>(), 0, 0, ans, candidates, target);
        return ans;
    }

    public void backtrack(List<Integer> path, int start, int currSum, List<List<Integer>> ans, int[] candidates, int target) {
        if (currSum == target) {
            ans.add(new ArrayList<>(path));
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            if (currSum + candidates[i] <= target) {
                path.add(candidates[i]);
                backtrack(path, i, currSum + candidates[i], ans, candidates, target);
                path.remove(path.size() - 1);
            }
        }
    }
}