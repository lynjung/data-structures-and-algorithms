class Solution {
    public int numberOfSubstrings(String s) {
        int n = s.length();
        int answer = 0;

        for (int targetZero = 0; targetZero + targetZero * targetZero <= n; targetZero++) {
            int left = 0;
            int lastInvalid = -1;
            int zeros = 0;
            int ones = 0;

            for (int right = 0; right < n; right++) {
                if (s.charAt(right) == '0') {
                    zeros++;
                } else {
                    ones++;
                }

                while (left < right) {
                    if (s.charAt(left) == '0' && zeros > targetZero) {
                        zeros--;
                        lastInvalid = left;
                        left++;
                    } else if (s.charAt(left) == '1' && ones - 1 >= targetZero * targetZero) {
                        ones--;
                        left++;
                    } else {
                        break;
                    }
                }

                if (zeros == targetZero && ones >= targetZero * targetZero) {
                    answer += left - lastInvalid;
                }
            }
        }

        return answer;
    }
}