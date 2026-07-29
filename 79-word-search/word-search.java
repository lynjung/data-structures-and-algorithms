class Solution {
    int m;
    int n;
    String target;
    int[][] directions = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    boolean[][] seen;

    // find every possible starting cell
    public boolean exist(char[][] board, String word) {
        m = board.length;
        n = board[0].length;
        target = word;
        seen = new boolean[m][n];

        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                if (board[row][col] == word.charAt(0)) {
                    seen[row][col] = true;
                    if (backtrack(row, col, 1, board)) {
                        return true;
                    }
                    seen[row][col] = false;
                }
            }
        }

        return false;
    }

    // from each starting cell, recursively search for the rest of the word
    public boolean backtrack(int row, int col, int i, char[][] board) {
        if (i == target.length()) {
            return true;
        }

        for (int[] direction : directions) {
            int nextRow = row + direction[0];
            int nextCol = col + direction[1];

            if (valid(nextRow, nextCol) && !seen[nextRow][nextCol]) {
                if (board[nextRow][nextCol] == target.charAt(i)) {
                    seen[nextRow][nextCol] = true;
                    if (backtrack(nextRow, nextCol, i + 1, board)) {
                        return true;
                    }
                    seen[nextRow][nextCol] = false;
                }
            }
        }

        return false;
    }

    public boolean valid(int row, int col) {
        return 0 <= row && row < m && 0 <= col && col < n;
    }
}