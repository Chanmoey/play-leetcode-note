package LeetCode1971;

import java.util.*;

/**
 * @author Chanmoey
 * @date 2022年12月19日
 */
class Solution1 {
    public boolean validPath(int n, int[][] edges, int source, int destination) {

        if (n == 1) {
            return true;
        }

        boolean[] isVisited = new boolean[n];
        Map<Integer, Set<Integer>> path = new HashMap<>();

        for (int[] edge : edges) {
            path.computeIfAbsent(edge[0], k -> new HashSet<>()).add(edge[1]);
            path.computeIfAbsent(edge[1], k -> new HashSet<>()).add(edge[0]);
        }

       if (path.get(source).contains(destination) || path.get(destination).contains(source)) {
           return true;
       }

        Deque<Integer> queue = new ArrayDeque<>();
        Set<Integer> searchPath = new HashSet<>();
        queue.add(source);
        while (!queue.isEmpty()) {
            int cur = queue.removeFirst();
            searchPath.add(cur);
            isVisited[cur] = true;

            Set<Integer> nextList = path.get(cur);

            if (searchPath.contains(source) && searchPath.contains(destination)) {
                return true;
            }

            if (nextList != null) {
                for (Integer next : nextList) {
                    if (!isVisited[next]) {
                        queue.addLast(next);
                    }
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Solution1 s = new Solution1();
        s.validPath(10, new int[][]{{0, 7}, {0, 8}, {6, 1}, {2, 0}, {0, 4}, {5, 8}, {4, 7}, {1, 3}, {3, 5}, {6, 5}}, 7, 5);
    }
}
