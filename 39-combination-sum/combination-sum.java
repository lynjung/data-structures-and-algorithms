class Solution {
    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<Integer> current = new ArrayList<>();
        backtrack(candidates, target, 0, current);
        return ans;
    }

    public void backtrack(int[] candidates, int remaining, int start, List<Integer> current) {
        if (remaining == 0) {
            ans.add(new ArrayList<>(current));
            return;
        }

        if (remaining < 0) {
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            current.add(candidates[i]);
            backtrack(candidates, remaining - candidates[i], i, current);
            current.remove(current.size() - 1);
        }
    }
}