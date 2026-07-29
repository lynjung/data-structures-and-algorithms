class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        backtrack("", n, ans, 0, 0);
        return ans;
    }

    public void backtrack(String curr, int n, List<String> ans, int open, int close) {
        if (curr.length() == 2 * n) {
            ans.add(curr);
        }

        if (open < n) {
            backtrack(curr + "(", n, ans, open + 1, close);
        }

        if (close < open) {
            backtrack(curr + ")", n, ans, open, close + 1);
        }
    }
}