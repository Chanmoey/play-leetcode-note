package LeetCode773;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Chanmoey
 * @date 2022年03月04日
 */
class Solution {

    private static final String SUCCESS = "123450";
    private static final int[][] DIRS = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public int slidingPuzzle(int[][] board) {

        Queue<String> queue = new LinkedList<>();
        HashMap<String, Integer> visited = new HashMap<>();

        String initialState = this.boardToString(board);
        if (SUCCESS.equals(initialState)) {
            return 0;
        }
        queue.add(initialState);
        visited.put(initialState, 0);

        while (!queue.isEmpty()) {
            String cur = queue.remove();

            ArrayList<String> nexts = getNexts(cur);

            for (String next : nexts) {
                if (!visited.containsKey(next)) {
                    queue.add(next);
                    visited.put(next, visited.get(cur) + 1);

                    if (SUCCESS.equals(next)) {
                        return visited.get(next);
                    }
                }
            }
        }

        return -1;
    }

    private String boardToString(int[][] board) {
        StringBuilder sb = new StringBuilder();
        for (int[] row : board) {
            for (int num : row) {
                sb.append(num);
            }
        }

        return sb.toString();
    }

    private int[][] stringToBoard(String s) {
        int[][] board = new int[2][3];
        for (int i = 0; i < 6; i++) {
            board[i / 3][i % 3] = s.charAt(i) - '0';
        }

        return board;
    }

    private ArrayList<String> getNexts(String s) {
        int[][] cur = this.stringToBoard(s);
        int zero;
        for (zero = 0; zero < 6; zero++) {
            if (cur[zero / 3][zero % 3] == 0) {
                break;
            }
        }

        int zx = zero / 3, zy = zero % 3;
        ArrayList<String> res = new ArrayList<>();

        for (int d = 0; d < 4; d++) {
            int nextX = zx + DIRS[d][0];
            int nextY = zy + DIRS[d][1];

            if (this.inArea(nextX, nextY)) {
                swap(cur, zx, zy, nextX, nextY);
                res.add(this.boardToString(cur));
                swap(cur, zx, zy, nextX, nextY);
            }
        }

        return res;
    }

    private boolean inArea(int x, int y) {
        return x >= 0 && x < 2 && y >= 0 && y < 3;
    }

    private void swap(int[][] board, int ox, int oy, int nx, int ny) {
        int temp = board[ox][oy];
        board[ox][oy] = board[nx][ny];
        board[nx][ny] = temp;
    }
}
