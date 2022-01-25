package LeetCode36;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Chanmoey
 * @date 2022年01月25日
 */
class Solution {
    public boolean isValidSudoku(char[][] board) {
        return this.validRow(board)
                && validCol(board)
                && valid3x3(board);
    }

    private boolean validRow(char[][] board) {

        Map<Integer, Integer> map = new HashMap<>(18);

        for (char[] chars : board) {
            map.clear();
            for (int col = 0; col < board[0].length; col++) {
                if (chars[col] != '.') {
                    int number = this.digit(chars[col]);
                    if (number != -1) {
                        if (map.containsKey(number)) {
                            return false;
                        }
                        map.put(number, 1);
                    }
                }
            }
        }

        return true;
    }

    private boolean validCol(char[][] board) {
        Map<Integer, Integer> map = new HashMap<>(18);

        for (int col = 0; col < board[0].length; col++) {
            map.clear();
            for (int row = 0; row < board.length; row++) {
                if (isDuplicate(board, map, row, col)) {
                    return false;
                }
            }
        }

        return true;
    }

    private boolean valid3x3(char[][] board) {
        Map<Integer, Integer> map = new HashMap<>(18);
        int rowStart = 0, colStart = 0;
        while (rowStart <= 7) {
            map.clear();
            for (int row = rowStart; row < rowStart + 3; row++) {
                for (int col = colStart; col < colStart + 3; col++) {
                    if (isDuplicate(board, map, row, col)) {
                        return false;
                    }
                }
            }
            colStart += 3;
            if (colStart >= 9) {
                colStart = 0;
                rowStart += 3;
            }
        }

        return true;
    }

    private boolean isDuplicate(char[][] board, Map<Integer, Integer> map, int row, int col) {
        if (board[row][col] != '.') {
            int number = this.digit(board[row][col]);
            if (number != -1) {
                if (map.containsKey(number)) {
                    return true;
                }
                map.put(number, 1);
            }
        }
        return false;
    }

    private int digit(char c) {
        int number = c - '0';
        if (number >= 1 && number <= 9) {
            return number;
        }

        return -1;
    }
}
