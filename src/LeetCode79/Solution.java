package LeetCode79;

class Solution {

    private final int[][] d = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    private boolean[][] visited;
    private int m, n;

    public boolean exist(char[][] board, String word) {

        this.m = board.length;
        assert m > 0;
        this.n = board[0].length;

        this.visited = new boolean[m][n];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (this.searchWord(board, word, 0, i, j)){
                    return true;
                }
            }
        }

        return false;
    }

    private boolean searchWord(char[][] board, String word, int index, int x, int y) {

        if (index == word.length() - 1) {
            return board[x][y] == word.charAt(index);
        }

        if (board[x][y] == word.charAt(index)) {
            this.visited[x][y] = true;
            for (int i = 0; i < 4; i++) {
                int newX = x + this.d[i][0];
                int newY = y + this.d[i][1];
                if (this.inArea(newX, newY) && !visited[newX][newY] && searchWord(board, word, index + 1, newX, newY)) {
                    return true;
                }
            }
            visited[x][y] = false;
        }

        return false;
    }

    private boolean inArea(int x, int y) {
        return x >= 0 && x < this.m && y >= 0 && y < this.n;
    }
}
