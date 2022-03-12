package LeetCode1905;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Chanmoey
 * @date 2022年03月12日
 */
class Solution {

    private static final int[][] DIRS = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    private int[][] grid1, grid2;
    int m, n;
    List<List<int[]>> landInGrid2 = new ArrayList<>();

    public int countSubIslands(int[][] grid1, int[][] grid2) {
        this.grid1 = grid1;
        this.grid2 = grid2;
        this.m = grid1.length;
        this.n = grid1[0].length;

        int index = 0;
        for (int i = 0; i < this.m; i++) {
            for (int j = 0; j < this.n; j++) {
                if (this.grid2[i][j] == 1) {
                    this.landInGrid2.add(new ArrayList<>());
                    collectLandInGrid2(i, j, index);
                    index++;
                }
            }
        }

        return this.countSubLand();
    }

    private void collectLandInGrid2(int x, int y, int index) {
        this.landInGrid2.get(index).add(new int[]{x, y});
        this.grid2[x][y] = 0;

        for (int[] dir : DIRS) {
            int nextX = x + dir[0];
            int nextY = y + dir[1];
            if (this.inArea(nextX, nextY) && this.grid2[nextX][nextY] == 1) {
                collectLandInGrid2(nextX, nextY, index);
            }
        }
    }

    private boolean inArea(int x, int y) {
        return x >= 0 && x < this.m && y >= 0 && y < this.n;
    }

    private int countSubLand() {
        int res = 0;
        for (List<int[]> land : this.landInGrid2) {
            boolean isSubLand = true;
            for (int[] coordinate : land) {
                if (this.grid1[coordinate[0]][coordinate[1]] != 1) {
                    isSubLand = false;
                    break;
                }
            }
            if (isSubLand) {
                res++;
            }
        }

        return res;
    }
}
