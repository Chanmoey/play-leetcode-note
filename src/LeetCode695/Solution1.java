package LeetCode695;

import java.util.HashSet;

/**
 * 图
 *
 * @author Chanmoey
 * @date 2022年03月03日
 */
class Solution1 {

    private int[][] dirs = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    private int m, n;
    private int[][] grid;

    private HashSet<Integer>[] graph;
    private boolean[] visited;

    public int maxAreaOfIsland(int[][] grid) {
        if (grid == null) {
            return 0;
        }

        this.m = grid.length;
        if (this.m == 0) {
            return 0;
        }
        this.n = grid[0].length;
        if (this.n == 0) {
            return 0;
        }

        this.grid = grid;

        this.graph = makeGraph();

        int res = 0;
        this.visited = new boolean[this.graph.length];
        for (int v = 0; v < this.graph.length; v++) {
            int x = v / this.n;
            int y = v % this.n;
            if (!visited[v] && grid[x][y] == 1) {
                res = Math.max(res, dfs(v));
            }
        }

        return res;
    }

    private int dfs(int v) {
        this.visited[v] = true;
        int res = 1;
        for (int w : this.graph[v]) {
            if (!visited[w]) {
                res += dfs(w);
            }
        }
        return res;
    }

    private HashSet<Integer>[] makeGraph() {
        HashSet<Integer>[] g = new HashSet[this.m * this.n];
        for (int i = 0; i < g.length; i++) {
            g[i] = new HashSet<>();
        }

        for (int v = 0; v < g.length; v++) {
            int x = v / this.n;
            int y = v % this.n;
            if (this.grid[x][y] == 1) {
                for (int d = 0; d < 4; d++) {
                    int newX = x + dirs[d][0];
                    int newY = y + dirs[d][1];
                    if (inArea(newX, newY) && this.grid[newX][newY] == 1) {
                        int next = newX * this.n + newY;
                        g[v].add(next);
                        g[next].add(v);
                    }
                }
            }
        }
        return g;
    }

    private boolean inArea(int x, int y) {
        return x >= 0 && x < this.m && y >= 0 && y < this.n;
    }
}
