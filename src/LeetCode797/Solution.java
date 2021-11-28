package LeetCode797;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Chanmoey
 * @date 2021年11月28日 9:54
 * @description
 */
class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {

        List<List<Integer>> res = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        cur.add(0);
        dfs(graph, 0, cur, res);
        return res;
    }

    private void dfs(int[][] graph, int start, List<Integer> cur,
                     List<List<Integer>> res) {

        if (start == graph.length - 1) {
            List<Integer> temp = new ArrayList<>(cur);
            res.add(temp);
            return;
        }

        for (int next : graph[start]) {
            cur.add(next);
            dfs(graph, next, cur, res);
            cur.remove(cur.size() - 1);
        }
    }
}
