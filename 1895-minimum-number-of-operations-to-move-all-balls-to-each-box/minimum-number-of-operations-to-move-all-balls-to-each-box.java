class Solution {
    public int[] minOperations(String boxes) {
        
        int n = boxes.length();
        int[] answer = new int[n];

        int leftBalls = 0;
        int leftMoves = 0;

        for (int i = 0; i < n; i++) {
            answer[i] += leftMoves;

            if (boxes.charAt(i) == '1') {
                leftBalls++;
            }
            leftMoves += leftBalls;
        }

        int rightBalls = 0;
        int rightMoves = 0;

        for (int i = n - 1; i >= 0; i--) {
            answer[i] += rightMoves;

            if (boxes.charAt(i) == '1') {
                rightBalls++;
            }
            rightMoves += rightBalls;
        }
        return answer;
    }
}