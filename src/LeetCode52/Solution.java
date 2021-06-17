package LeetCode52;

class Solution {

    private int res;
    private boolean[] col, dia1, dia2;

    public int totalNQueens(int n) {
        // 初始化
        this.res = 0;
        this.col = new boolean[n];
        this.dia1 = new boolean[2 * n - 1];
        this.dia2 = new boolean[2 * n - 1];

        // 开始寻找解
        this.putQueen(n, 0);

        return this.res;
    }

    // 摆放第index行的皇后的位置
    private void putQueen(int n, int index) {

        if (index == n) {
            this.res++;
            return;
        }

        for (int i = 0; i < n; i++) {
            // 将index行的皇后摆放在第i列
            if (!this.col[i] && !this.dia1[index + i] && !this.dia2[index - i + n - 1]) {
                this.col[i] = true;
                this.dia1[index + i] = true;
                this.dia2[index - i + n - 1] = true;
                this.putQueen(n, index + 1);
                // 回溯
                this.col[i] = false;
                this.dia1[index + i] = false;
                this.dia2[index - i + n - 1] = false;
            }
        }
        // return;
    }
}
