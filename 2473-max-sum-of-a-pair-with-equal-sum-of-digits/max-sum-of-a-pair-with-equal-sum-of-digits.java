class Solution {
    public int maximumSum(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>(); // digit sum - max # seen so far with that digit sum
        int ans = -1;

        for (int num : nums) {
            int digitSum = getDigitSum(num);
            if (map.containsKey(digitSum)) {
                ans = Math.max(ans, map.get(digitSum) + num);
            }
            map.put(digitSum, Math.max(map.getOrDefault(digitSum, 0), num));
        }

        return ans;
    }

    public int getDigitSum(int num) {
            int digitSum = 0;

            while (num > 0) {
                digitSum += num % 10;
                num /= 10;
            }
            return digitSum;
        }
}