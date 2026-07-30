class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        backtrack(new ArrayList<>(), 0, 1, k, n, ans);
        return ans;
    }

    private void backtrack(List<Integer> curr, int currSum, int start, int k, int n, List<List<Integer>> ans) {
        if (curr.size() == k) {
            if (currSum == n) {
                ans.add(new ArrayList<>(curr));
            }
            return;
        }

        for (int num = start; num <= 9; num++) {
            if (currSum + num > n) {
                break;
            }

            curr.add(num);

            backtrack(curr, currSum + num, num + 1, k, n, ans);

            curr.remove(curr.size() - 1);
        }
    }
}