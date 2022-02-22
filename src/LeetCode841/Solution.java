package LeetCode841;

import java.util.*;

/**
 * @author Chanmoey
 * @date 2022年02月22日
 */
class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        Set<Integer> isVisited = new HashSet<>();
        boolean[] seen = new boolean[n];

        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(0);

        while (!queue.isEmpty()) {
            int openRoom = queue.poll();
            isVisited.add(openRoom);

            if (!seen[openRoom]) {
                for (int key : rooms.get(openRoom)) {
                    if (!seen[key]) {
                        queue.add(key);
                    }
                }
            }
            seen[openRoom] = true;
        }

        return isVisited.size() == n;
    }
}
