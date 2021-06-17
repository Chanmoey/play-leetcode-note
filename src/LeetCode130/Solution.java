package LeetCode130;

import javafx.util.Pair;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

class Solution {

    private int m, n;
    int[][] d = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public void solve(char[][] board) {
        this.m = board.length;
        if (m == 0) {
            return;
        }
        this.n = board[0].length;
        if (n == 0) {
            return;
        }

        boolean[][] visited = new boolean[m][n];
        List<Pair<Integer, Integer>> record = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O' && !visited[i][j]) {
                    record.clear();
                    if (this.floodFill(board, i, j, visited, record)) {
                        for (Pair<Integer, Integer> integerIntegerPair : record) {
                            board[integerIntegerPair.getKey()][integerIntegerPair.getValue()] = 'X';
                        }
                    }
                }
            }
        }
    }

    private boolean inArea(int x, int y) {
        return x >= 0 && x < this.m && y >= 0 && y < this.n;
    }

    private boolean floodFill(char[][] board, int x, int y, boolean[][] visited,
                           List<Pair<Integer, Integer>> record) {

        Deque<Pair<Integer, Integer>> q = new ArrayDeque<>();
        boolean ret = true;

        visited[x][y] = true;
        q.addLast(new Pair<>(x, y));
        while (!q.isEmpty()) {
            Pair<Integer, Integer> cur = q.removeFirst();
            record.add(cur);


            for (int i = 0; i < 4; i++) {
                int newX = cur.getKey() + this.d[i][0];
                int newY = cur.getValue() + this.d[i][1];
                if (!this.inArea(newX, newY)) {
                    ret = false;
                }
                else if (board[newX][newY] == 'O' && !visited[newX][newY]) {
                    visited[newX][newY] = true;
                    q.addLast(new Pair<>(newX, newY));
                }
            }

        }

        return ret;
    }
}
