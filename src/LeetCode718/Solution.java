package LeetCode718;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 错误题解。理解错了，我以为要求交集。
 *
 * @author Chanmoey
 * @date 2022年06月03日
 */
class Solution {
    public int findLength(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>(nums1.length * 2);
        List<Integer> subSet = new ArrayList<>();

        for (int num : nums1) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for (int num : nums2) {
            if (map.containsKey(num) && map.get(num) > 0) {
                subSet.add(num);
                map.put(num, map.get(num) - 1);
            }
        }

        return subSet.size();
    }
}
