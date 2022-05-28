package LeetCode1481;

import java.util.*;

/**
 * @author Chanmoey
 * @date 2022年05月28日
 */
class Solution {

    // 如果使用优先队列，性能会不会更优。
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        Map<Integer, Integer> map = new HashMap<>(arr.length * 2);
        for (int num : arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet().stream().toList());

        list.sort(Comparator.comparingInt(Map.Entry::getValue));
        int res = list.size();

        for (Map.Entry<Integer, Integer> entry : list) {
            if (k >= entry.getValue()) {
                k -= entry.getValue();
                res--;
            }
            if (k <= 0) {
                break;
            }
        }

        return res;
    }
}
