package LeetCode1192;

import java.util.*;

/**
 * 找桥。
 *
 * @author Chanmoey
 * @date 2022年05月18日
 */
class Solution {
    private final List<List<Integer>> res = new ArrayList<>();
    private int[] order;
    private int[] low;
    int cnt = 0;
    private Map<Integer, Set<Integer>> graph;


    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {

        // 这里使用List<Set<Integer>> graph = new LinkedList(); 居然会超时，我是感受到LinkedList在这个场景下的性能了。
        this.graph = new HashMap<>(2 * n);
        this.order = new int[n];
        this.low = new int[n];

        // create a graph
        for (int i = 0; i < n; i++) {
            graph.put(i, new HashSet<>());
        }
        for (List<Integer> e : connections) {
            graph.get(e.get(0)).add(e.get(1));
            graph.get(e.get(1)).add(e.get(0));
        }

        this.cnt = 1;
        this.dfs(0, -1);
        return this.res;
    }

    private void dfs(int v, int parent) {
        this.order[v] = this.low[v] = this.cnt++;

        for (int w : this.graph.get(v)) {
            if (this.order[w] == 0) {
                dfs(w, v);
                this.low[v] = Math.min(this.low[v], this.low[w]);
            } else if (w != parent) {
                this.low[v] = Math.min(this.low[v], this.order[w]);
            }

            if (this.low[w] > this.order[v]) {
                this.res.add(Arrays.asList(v, w));
            }
        }
    }
}
