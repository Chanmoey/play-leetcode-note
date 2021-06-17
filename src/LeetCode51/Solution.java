package LeetCode51;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

class Solution {

    private List<List<String>> res;
    private boolean[] col, dia1, dia2;

    public List<List<String>> solveNQueens(int n) {
        // 初始化
        this.res = new ArrayList<>();
        this.col = new boolean[n];
        this.dia1 = new boolean[2 * n - 1];
        this.dia2 = new boolean[2 * n - 1];
        LinkedList<Integer> row = new LinkedList<>();

        // 开始寻找解
        this.putQueen(n, 0, row);

        return this.res;
    }

    // 摆放第index行的皇后的位置
    private void putQueen(int n, int index, LinkedList<Integer> row) {

        if (index == n) {
            this.res.add(this.generateBoard(n, row));
            return;
        }

        for (int i = 0; i < n; i++) {
            // 将index行的皇后摆放在第i列
            if (!this.col[i] && !this.dia1[index + i] && !this.dia2[index - i + n - 1]) {
                row.addLast(i);
                this.col[i] = true;
                this.dia1[index + i] = true;
                this.dia2[index - i + n - 1] = true;
                this.putQueen(n, index + 1, row);
                // 回溯
                this.col[i] = false;
                this.dia1[index + i] = false;
                this.dia2[index - i + n - 1] = false;
                row.removeLast();
            }
        }
        // return;
    }

    private List<String> generateBoard(int n, LinkedList<Integer> row) {
        assert row.size() == n;

        char[] c = new char[n];
        Arrays.fill(c, '.');

        List<String> board = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            c[row.get(i)] = 'Q';
            board.add(new String(c));
            c[row.get(i)] = '.';
        }

        return board;
    }
}
