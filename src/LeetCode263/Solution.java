package LeetCode263;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * @author Chanmoey
 * @date 2022年11月18日
 */
class Solution {
    private int orientation(int[] p, int[] q, int[] r) {
        return (r[1] - q[1]) * (q[0] - p[0]) - ((q[1] - p[1]) * (r[0] - q[0]));
    }

    public int[][] outerTrees(int[][] trees) {
        Stack<int[]> upper = new Stack<>();
        Stack<int[]> lower = new Stack<>();
        Arrays.sort(trees, (p, q) ->
                q[0] - p[0] == 0 ? q[1] - p[1] : q[0] - p[0]);
        for (int[] tree : trees) {
            while (lower.size() >= 2 && orientation(lower.get(lower.size() - 2), lower.get(lower.size() - 1), tree) > 0) {
                lower.pop();
            }
            while (upper.size() >= 2 && orientation(upper.get(upper.size() - 2), upper.get(upper.size() - 1), tree) < 0) {
                upper.pop();
            }
            lower.push(tree);
            upper.push(tree);

        }
        Set<int[]> res = new HashSet<>(lower);
        res.addAll(upper);
        return res.toArray(new int[res.size()][]);

    }
}