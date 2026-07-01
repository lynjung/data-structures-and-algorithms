class State {
    int row;
    int col;
    int steps;
    State(int row, int col, int steps) {
        this.row = row;
        this.col = col;
        this.steps = steps;
    }
}

class Solution {
    int n;
    int[][] directions = new int[][]{{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};

    public int shortestPathBinaryMatrix(int[][] grid) {
        if (grid[0][0] == 1) {
            return -1;
        }

        n = grid.length;
        boolean[][] seen = new boolean[n][n];
        seen[0][0] = true;

        Queue<State> q = new LinkedList<>();
        q.add(new State(0, 0, 1));

        while (!q.isEmpty()) {
            State state = q.remove();
            int row = state.row, col = state.col, steps = state.steps;
            if (row == n - 1 && col == n - 1) {
                return steps;
            }

            for (int[] direction : directions) {
                int nextRow = row + direction[0], nextCol = col + direction[1];
                if (valid(nextRow, nextCol, grid) && !seen[nextRow][nextCol]) {
                    seen[nextRow][nextCol] = true;
                    q.add(new State(nextRow, nextCol, steps + 1));
                }
            }
        }

        return -1;
    }

    public boolean valid(int row, int col, int[][] grid) {
        return 0 <= row && row < n && 0 <= col && col < n && grid[row][col] == 0;
    }
}