class Solution {
    public int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }

        int pprev = 1;
        int prev = 2;

        for (int i = 2; i < n; i++) {
            int curr = pprev + prev;
            pprev = prev;
            prev = curr;
        }
        return prev;
    }
}