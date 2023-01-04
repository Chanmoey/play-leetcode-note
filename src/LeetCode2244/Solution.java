package LeetCode2244;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Chanmoey
 * @date 2023年01月04日
 */
class Solution {
    public int minimumRounds(int[] tasks) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int task : tasks) {
            map.put(task, map.getOrDefault(task, 0) + 1);
        }

        int res = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() < 2) {
                return -1;
            } else {
                int count3 = entry.getValue() / 3;
                int count2 = entry.getValue() % 3;

                if (count2 == 0) {
                    res += count3;
                } else {
                    res += count3 + 1;
                }
            }
        }
        return res;
    }
}
