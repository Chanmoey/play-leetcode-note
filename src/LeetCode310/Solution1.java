package LeetCode310;

import java.util.*;

/**
 * @author Chanmoey
 * @date 2021年12月16日 21:22
 * @description  参考评论区答案
 */
public class Solution1 {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Set<Integer>> sets = new ArrayList<>();
        for (int i = 0; i < n; i++)
            sets.add(new HashSet<>());

        for (int[] edge : edges) {
            sets.get(edge[0]).add(edge[1]);
            sets.get(edge[1]).add(edge[0]);
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (sets.get(i).size() < 2)
                q.offer(i);
        }
        while (n > 2) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int curr = q.poll();
                int next = sets.get(curr).iterator().next();
                sets.get(next).remove(curr);
                if (sets.get(next).size() == 1)
                    q.offer(next);
            }
            n -= size;
        }
        return new ArrayList<>(q);
    }
}
