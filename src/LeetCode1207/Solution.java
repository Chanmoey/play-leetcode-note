package LeetCode1207;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author Chanmoey
 * @date 2022年11月30日
 */
class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>(arr.length * 2);

        for (int num : arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        Set<Integer> set = new HashSet<>(arr.length);

        for (Integer i : map.values()) {
            if (set.contains(i)) {
                return false;
            } else {
                set.add(i);
            }
        }

        return true;
    }
}
