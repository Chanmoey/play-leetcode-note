package LeetCode454;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        int res = 0;

        Map<Integer, Integer> recode = new HashMap<>();
        for (int k : nums1) {
            for (int i : nums2) {
                int sum = k + i;
                recode.put(sum, recode.getOrDefault(sum, 0));
            }
        }

        for (int k : nums3) {
            for (int i : nums4) {
                if (recode.containsKey(-k - i)){
                    res += recode.get(-k - i);
                }
            }
        }

        return res;
    }
}