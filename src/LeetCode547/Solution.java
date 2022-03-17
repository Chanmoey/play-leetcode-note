package LeetCode547;

/**
 * @author Chanmoey
 * @date 2022年03月17日
 */
class Solution {

    private boolean[] visited;
    private int[][] graph;

    public int findCircleNum(int[][] isConnected) {
        this.visited = new boolean[isConnected.length];
        this.graph = isConnected;
        int count = 0;

        for (int i = 0; i < isConnected.length; i++) {
            if (!visited[i]) {
                count ++;
                this.dfs(i);
            }
        }

        return count;
    }

    private void dfs(int v) {
        this.visited[v] = true;

        for (int i = 0; i < this.graph[v].length; i ++) {
            if (i != v && !this.visited[i] && this.graph[v][i] == 1) {
                dfs(i);
            }
        }
    }
}
