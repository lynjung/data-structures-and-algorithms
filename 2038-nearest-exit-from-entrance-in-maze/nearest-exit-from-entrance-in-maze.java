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
    int m;
    int n;
    int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public int nearestExit(char[][] maze, int[] entrance) {
        m = maze.length;
        n = maze[0].length;

        Queue<State> queue = new LinkedList<>();
        boolean[][] seen = new boolean[m][n];

        queue.add(new State(entrance[0], entrance[1], 0));
        seen[entrance[0]][entrance[1]] = true;

        while (!queue.isEmpty()) {
            State state = queue.remove();
            int row = state.row, col = state.col, steps = state.steps;

            if ((row != entrance[0] || col != entrance[1]) && (row == 0 || row == m - 1 || col == 0 || col == n - 1)) {
                return steps;
            }

            for (int[] direction: directions) {
                int nextRow = row + direction[0];
                int nextCol = col + direction[1];

                if (valid(nextRow, nextCol, maze) && !seen[nextRow][nextCol]) {
                    seen[nextRow][nextCol] = true;
                    queue.add(new State(nextRow, nextCol, steps + 1));
                }
            }
        }

        return -1;
    }

    public boolean valid(int row, int col, char[][] maze) {
        return 0 <= row && row < m && 0 <= col && col < n && maze[row][col] == '.';
    }
}