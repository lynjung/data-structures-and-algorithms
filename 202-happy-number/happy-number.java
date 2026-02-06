class Solution {
    public boolean isHappy(int n) {

        HashSet<Integer> set = new HashSet<>();

        while (!set.contains(n)) {
            set.add(n);
            n = sumOfSquares(n);

            if (n == 1) return true;
        }

        return false;
    }

    private int sumOfSquares(int x) {
            int sum = 0;

            while (x > 0) {
                int d = x % 10;
                sum += d * d;
                x /= 10;
            }
            return sum;
        }
}