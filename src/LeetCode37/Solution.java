package LeetCode37;

class Solution {

    private final int boardLength = 81;
    private final int rowAndColLength = 9;

    public void solveSudoku(char[][] board) {

        boolean[][] row = new boolean[9][10];
        boolean[][] col = new boolean[9][10];
        boolean[][] block = new boolean[9][10];

        for (int i = 0; i < rowAndColLength; i++) {
            for (int j = 0; j < rowAndColLength; j++) {
                if (board[i][j] != '.') {
                    row[i][board[i][j] - '0'] = true;
                    col[j][board[i][j] - '0'] = true;
                    block[i / 3 * 3 + j / 3][board[i][j] - '0'] = true;
                }
            }

        }

        for (int i = 0; i < boardLength; i++) {
            if (board[i / 9][i % 9] == '.') {
                assert (dfs(board, i, row, col, block));
                return;
            }
        }

    }

    private boolean dfs(char[][] board, int pos,
                        boolean[][] row, boolean[][] col,
                        boolean[][] block) {
        if (pos == boardLength) {
            return true;
        }


        int next = pos + 1;
        for (; next < boardLength; next++) {
            if (board[next / 9][next % 9] == '.') {
                break;
            }

        }


        int x = pos / 9, y = pos % 9;
        for (int i = 1; i <= rowAndColLength; i++) {
            if (!row[x][i] && !col[y][i] && !block[x / 3 * 3 + y / 3][i]) {
                row[x][i] = true;
                col[y][i] = true;
                block[x / 3 * 3 + y / 3][i] = true;
                board[x][y] = (char) ('0' + i);

                if (dfs(board, next, row, col, block)) {
                    return true;
                }

                row[x][i] = false;
                col[y][i] = false;
                block[x / 3 * 3 + y / 3][i] = false;
                board[x][y] = '.';
            }
        }

        return false;
    }
}
