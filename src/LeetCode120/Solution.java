package LeetCode120;

import java.util.List;

class Solution {

    /**
     * 动态规划的解法
     */
    public int minimumTotal(List<List<Integer>> triangle) {
        int depth = triangle.size();

        for (int i = 1; i < depth; i++) {

            // triangle[i][0] += triangle[i-1][0];
            triangle.get(i).set(0, triangle.get(i).get(0) + triangle.get(i - 1).get(0));

            // triangle[i][i] += triangle[i-1][i-1];
            triangle.get(i).set(i, triangle.get(i).get(i) + triangle.get(i - 1).get(i - 1));

            for (int j = 1; j < i; j++) {
                // triangle[i][j] += min(triangle[i-1][j-1], triangle[i-1][j]);
                triangle.get(i).set(j, triangle.get(i).get(j) + Math.min(triangle.get(i - 1).get(j - 1), triangle.get(i - 1).get(j)));
            }
        }

        int min = Integer.MAX_VALUE;
        for (Integer s : triangle.get(depth - 1)) {
            if (min > s) {
                min = s;
            }
        }

        return min;
    }

    /**
     * 自顶向下递归的方式，结果超时。
     */
    private int bfs(List<List<Integer>> triangle, int index, int depth) {

        if (depth == triangle.size()) {
            return 0;
        }

        return triangle.get(depth).get(index) + Math.min(this.bfs(triangle, index, depth + 1),
                this.bfs(triangle, index + 1, depth + 1));
    }
}
