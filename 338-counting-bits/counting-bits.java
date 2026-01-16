class Solution {
    public int[] countBits(int n) {
        
        int[] ans = new int[n + 1];
        ans[0] = 0; // not needed bc 0 by default
        int offset = 1;

        for (int i = 1; i < n + 1; i++) {
            if (i == (2 * offset)) {
                offset = i;
            }
            ans[i] = 1 + ans[i - offset];
        }
        return ans;
    }
}