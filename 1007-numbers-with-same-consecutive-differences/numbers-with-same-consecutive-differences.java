class Solution {
    public int[] numsSameConsecDiff(int n, int k) {
        List<Integer> ans = new ArrayList<>();

        // first digit cannot be 0
        for (int first = 1; first <= 9; first++) {
            backtrack(first, 1, n, k, ans);
        }

        int[] result = new int[ans.size()];

        for (int i = 0; i < ans.size(); i++) {
            result[i] = ans.get(i);
        }

        return result;
    }

    private void backtrack(int curr, int digitsUsed, int n, int k, List<Integer> ans) {
        if (digitsUsed == n) {
            ans.add(curr);
            return;
        }

        int last = curr % 10;

        int next1 = last + k;
        int next2 = last - k;

        if (0 <= next1 && next1 <= 9) {
            int nextNum = curr * 10 + next1;
            backtrack(nextNum, digitsUsed + 1, n, k, ans);
        }

        if (0 <= next2 && next2 <= 9 && next1 != next2) {
            int nextNum = curr * 10 + next2;
            backtrack(nextNum, digitsUsed + 1, n, k, ans);
            curr = (curr - next2) / 10;
        }
    }
}