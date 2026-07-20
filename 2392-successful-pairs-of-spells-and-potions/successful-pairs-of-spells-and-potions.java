class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);
        int[] ans = new int[spells.length];
        int m = potions.length;

        for (int i = 0; i < spells.length; i++) {
            int j = binarySearch(potions, success / (double)spells[i]);
            ans[i] = m - j;
        }
        return ans;
    }

    public int binarySearch(int[] arr, double target) {
        int left = 0;
        int right = arr.length;

        while (left < right) {
            int mid = left + (right - left) / 2;
            int num = arr[mid];

            if (num < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}