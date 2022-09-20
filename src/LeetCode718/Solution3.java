package LeetCode718;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Time Limit Exceeded
 *
 * @author Chanmoey
 * @date 2022年09月20日
 */
class Solution3 {
    public int findLength(int[] nums1, int[] nums2) {
        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < nums2.length; i++) {
            map.computeIfAbsent(nums2[i], key -> new ArrayList<>()).add(i);
        }
        int res = 0;
        for (int i = 0; i < nums1.length; i++) {
            if (map.containsKey(nums1[i])) {
                List<Integer> indexes = map.get(nums1[i]);
                for (int j : indexes) {
                    int item = 1;
                    int p = i + 1;
                    int q = j + 1;
                    while (p < nums1.length && q < nums2.length) {
                        if (nums1[p++] == nums2[q++]) {
                            item++;
                        } else{
                            break;
                        }
                    }

                    res = Math.max(res, item);
                }
            }
        }

        return res;
    }
}
