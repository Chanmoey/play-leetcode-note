package LeetCode454;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        int res = 0;
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        Arrays.sort(nums3);
        Arrays.sort(nums4);

        Map<Integer, Integer> recode = new HashMap<>(2 * nums1.length);
        for (int k : nums1) {
            for (int i : nums2) {
//                int sum = k + i;
//                recode.put(sum, recode.getOrDefault(sum, 0) + 1);
                recode.compute(k + i, (key, value) -> value == null ? 1 : value + 1);
            }
        }

        for (int k : nums3) {
            for (int i : nums4) {
//                if (recode.containsKey(-k - i)){
//                    res += recode.get(-k - i);
//                }
                res += recode.getOrDefault(-(k + i), 0);
            }
        }

        return res;
    }
}