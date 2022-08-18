package LeetCode1338;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Chanmoey
 * @date 2022年08月18日
 */
class Solution {
    public int minSetSize(int[] arr) {
        int size = arr.length;
        int limit = size / 2;
        Map<Integer, Integer> map = new HashMap<>(arr.length * 2);
        for (int i : arr) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        List<Map.Entry<Integer, Integer>> list = map.entrySet()
                .stream().sorted((a, b) -> b.getValue() - a.getValue()).toList();

        int res = 0;
        for (Map.Entry<Integer, Integer> entry : list) {
            size -= entry.getValue();
            res++;
            if (size <= limit) {
                break;
            }
        }

        return res;
    }
}
