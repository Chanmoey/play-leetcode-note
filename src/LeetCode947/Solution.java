package LeetCode947;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Chanmoey
 * @date 2022年11月14日
 */
class Solution {
    public int removeStones(int[][] stones) {
        Set<Integer> delRow = new HashSet<>();
        Set<Integer> delCol = new HashSet<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int[] stone : stones) {
            map.put(stone[0], map.getOrDefault(stone[0], 0) + 1);
        }

        int res = 0;
        for (int[] stone : stones) {
            if (map.get(stone[0]) == 1 && map.get(stone[1]) == 1) {
                continue;
            }
            if (!delRow.contains(stone[0])) {
                res++;
                delRow.add(stone[0]);
            } else {
                if (!delCol.contains(stone[1])) {
                    res++;
                    delCol.add(stone[1]);
                }
            }
        }

        return res;
    }
}
