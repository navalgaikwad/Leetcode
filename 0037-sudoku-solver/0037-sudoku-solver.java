public class Solution {
    private int n = 9;
    private boolean[][] rows = new boolean[n][n + 1];
    private boolean[][] cols = new boolean[n][n + 1];
    private boolean[][] boxes = new boolean[n][n + 1];
    private boolean sudokuSolved = false;

    public void solveSudoku(char[][] board) {
        fillInitialSets(board);

        backtrack(board, 0, 0);
    }

    private void fillInitialSets(char[][] board) {
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                if (board[row][col] != '.') {
                    int val = board[row][col] - '0';
                    int box = (row / 3) * 3 + col / 3;
                    
                    rows[row][val] = true;
                    cols[col][val] = true;
                    boxes[box][val] = true;
                }
            }
        }
    }

    private void placeNextNumber(char[][] board, int row, int col) {
        if (col == n - 1 && row == n - 1) {
            sudokuSolved = true;
        } else {
            if (col != n - 1) {
                backtrack(board, row, col + 1);
            } else {
                backtrack(board, row + 1, 0);
            }
        }
    }

    private void backtrack(char[][] board, int row, int col) {
        if (board[row][col] == '.') {
            int box = (row / 3) * 3 + col / 3;
            for (int val = 1; val <= n; val++) {
                if (!(rows[row][val] || cols[col][val] || boxes[box][val])) {
                    // Make value update
                    rows[row][val] = true;
                    cols[col][val] = true;
                    boxes[box][val] = true;
                    board[row][col] = (char) ('0' + val);

                    // Place next number
                    placeNextNumber(board, row, col);

                    // Revert value update if sudoku not solved
                    if (!sudokuSolved) {
                        rows[row][val] = false;
                        cols[col][val] = false;
                        boxes[box][val] = false;
                        board[row][col] = '.';
                    }
                }
            }
        } else {
            // Place next number
            placeNextNumber(board, row, col);
        }
    }
}
