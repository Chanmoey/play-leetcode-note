package LeetCode733;

class Solution {

    private int m, n;
    private boolean[][] isVisited;
    private final int[][] direction = {{1, 0}, {0, -1}, {-1, 0}, {0, 1}};
    private int oldColor;

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {

        if (image[sr][sc] == newColor) {
            return image;
        }

        this.m = image.length;
        this.n = image[0].length;

        this.isVisited = new boolean[this.m][this.n];
        this.oldColor = image[sr][sc];

        // TODO: Let's go to flood fill;
        this._floodFill(image, sr, sc, newColor);
        return image;
    }

    private boolean inArea(int x, int y) {
        return x >= 0 && x < this.m && y >= 0 && y < this.n;
    }

    private void _floodFill(int[][] image, int x, int y, int newColor) {
        image[x][y] = newColor;
        this.isVisited[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int newX = x + this.direction[i][0];
            int newY = y + this.direction[i][1];
            if (this.inArea(newX, newY) && !isVisited[newX][newY] && image[newX][newY] == this.oldColor) {
                _floodFill(image, newX, newY, newColor);
            }
        }
    }
}
