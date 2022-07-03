package LeetCode1700;

import java.util.*;

/**
 * @author Chanmoey
 * @date 2022年07月03日
 */
class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        int top = 0;
        Map<Integer, Integer> map = new HashMap<>();
        Queue<Integer> queue = new ArrayDeque<>();
        map.put(0, 0);
        map.put(1, 0);
        for (int s : students) {
            queue.add(s);
            map.put(s, map.get(s) + 1);
        }

        while (top != sandwiches.length) {
            if (sandwiches[top] == queue.peek()) {
                top++;
                int s = queue.remove();
                map.put(s, map.get(s) - 1);
            } else {
                if (map.get(sandwiches[top]) == 0) {
                    return map.get(1 - sandwiches[top]);
                }

                queue.add(queue.remove());
            }
        }

        return 0;
    }
}
