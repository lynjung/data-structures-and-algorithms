class Solution {
    public int[] minOperations(String boxes) {
        
        int n = boxes.length();
        int[] answer = new int[n];

        int leftBalls = 0;
        int leftMoves = 0;

        for (int i = 0; i < n; i++) {
            answer[i] = leftBalls + leftMoves;
            leftMoves = answer[i];

            if (boxes.charAt(i) == '1') {
                leftBalls++;
            }
        }

        int rightBalls = 0;
        int rightMoves = 0;

        for (int i = n - 1; i >= 0; i--) {
            int r = rightBalls + rightMoves;
            answer[i] += r;
            rightMoves = r;

            if (boxes.charAt(i) == '1') {
                rightBalls++;
            }
        }
        return answer;
    }
}