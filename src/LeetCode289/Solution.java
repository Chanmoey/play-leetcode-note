package LeetCode289;

/**
 * @author Chanmoey
 * @date 2022年04月12日
 */
class Solution {
    public void gameOfLife(int[][] board) {
        int m = board.length;
        int n = board[0].length;

        int[][] res = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int num = 0;
                for (int ii = Math.max(0, i - 1); ii <= Math.min(i + 1, m - 1); ii++) {
                    for (int jj = Math.max(0, j - 1); jj <= Math.min(j + 1, n - 1); jj++) {
                        if (ii == i && jj == j) {
                            continue;
                        }
                        num += board[ii][jj];
                    }
                }

                if (board[i][j] == 1) {
                    if (num < 2 || num > 3) {
                        res[i][j] = 0;
                    } else {
                        res[i][j] = 1;
                    }
                } else {
                    if (num == 3) {
                        res[i][j] = 1;
                    }
                }
            }
        }

        for (int i = 0; i < m; i++) {
            System.arraycopy(res[i], 0, board[i], 0, n);
        }
    }
}
