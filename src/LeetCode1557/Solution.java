package LeetCode1557;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Chanmoey
 * @date 2022年02月22日
 */
class Solution {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        int[] reachable = new int[n];

        for (List<Integer> edge : edges) {
            reachable[edge.get(1)]++;
        }

        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < reachable.length; i++) {
            if (reachable[i] == 0) {
                res.add(i);
            }
        }

        return res;
    }
}
