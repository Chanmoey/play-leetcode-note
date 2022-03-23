package LeetCode991;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * 可以用图的广度优先遍历，但是在 startValue = 1，target = 1000000000的测试用例中，会超过实践。
 *
 * @author Chanmoey
 * @date 2022年03月23日
 */
class Solution {
    public int brokenCalc(int startValue, int target) {
        if (startValue == target) {
            return 0;
        }

        Set<Integer> visited = new HashSet<>();
        visited.add(startValue);
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{startValue, 0});

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int value = cur[0];
            int step = cur[1];

            int next1 = value * 2;
            int next2 = value - 1;

            if (!visited.contains(next1)) {
                queue.add(new int[] {next1, step + 1});
                if (next1 == target) {
                    return step + 1;
                }
            }

            if (next1 > target) {
                if (!visited.contains(next2)) {
                    queue.add(new int[] {next2, step + 1});
                    if (next2 == target) {
                        return step + 1;
                    }
                }
            }
        }
        return -1;
    }
}
