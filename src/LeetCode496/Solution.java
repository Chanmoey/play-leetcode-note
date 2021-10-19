package LeetCode496;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {

        if (nums2.length == 1) {
            return new int[]{-1};
        }

        Map<Integer, Integer> greater = new HashMap<>();

        greater.put(nums2[nums2.length - 1], -1);
        for (int i = nums2.length - 2; i >= 0; i--) {

            greater.put(nums2[i], -1);

            // 唉，想找到nextGreater还得遍历一遍，有没有更高效的做法？
            for (int j = i; j < nums2.length; j++) {
                if (nums2[j] > nums2[i]) {
                    greater.put(nums2[i], nums2[j]);
                    break;
                }
            }

        }

        int[] res = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            res[i] = greater.get(nums1[i]);
        }

        return res;
    }
}
