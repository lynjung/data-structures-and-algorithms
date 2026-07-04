class State {
    int square;
    int steps;

    State(int square, int steps) {
        this.square = square;
        this.steps = steps;
    }
}

class Solution {
    int n;

    public int snakesAndLadders(int[][] board) {
        n = board.length;

        Queue<State> queue = new LinkedList<>();
        boolean[] seen = new boolean[n * n + 1];

        queue.add(new State(1, 0));
        seen[1] = true;

        while (!queue.isEmpty()) {
            State state = queue.remove();
            int square = state.square, steps = state.steps;

            if (square == n * n) {
                return steps;
            }

            for (int next = square + 1; next <= Math.min(square + 6, n * n); next++) {
                int[] pos = getPosition(next);
                int row = pos[0], col = pos[1];

                int destination = next;

                if (board[row][col] != -1) {
                    destination = board[row][col];
                }

                if (!seen[destination]) {
                    seen[destination] = true;
                    queue.add(new State(destination, steps + 1));
                }
            }
        }

        return -1;
    }

    public int[] getPosition(int square) {
        int quot = (square - 1) / n;
        int rem = (square - 1) % n;

        int row = n - 1 - quot;
        int col;

        if (quot % 2 == 0) {
            col = rem;
        } else {
            col = n - 1 - rem;
        }

        return new int[]{row, col};
    }
}