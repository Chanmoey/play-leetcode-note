package LeetCode947;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Chanmoey
 * @date 2022年11月14日
 */
class Solution1 {
    Map<Integer, Integer> map = new HashMap<>();
    int count = 0;

    public int removeStones(int[][] stones) {
        for (int[] stone : stones) {
            union(stone[0], ~stone[1]);
        }
        return stones.length - count;
    }

    public int find(int pos) {
        if (map.putIfAbsent(pos, pos) == null) {
            count++;
        }
        if (pos != map.get(pos)) {
            map.put(pos, find(map.get(pos)));
        }
        return map.get(pos);
    }

    public void union(int x, int y) {
        x = find(x);
        y = find(y);
        if (x != y) {
            map.put(x, y);
            count--;
        }
    }
}
