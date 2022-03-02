package LeetCode496;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Chanmoey
 * @date 2022年03月02日
 */
public class Solution1 {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {

        if (nums2.length == 1) {
            return new int[]{-1};
        }

        int[] res = new int[nums1.length];

        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                if (nums1[i] == nums2[j]) {
                    int k = j + 1;
                    for (; k < nums2.length; k++) {
                        if (nums2[k] > nums1[i]) {
                            res[i] = nums2[k];
                            break;
                        }
                    }
                    if (k >= nums2.length) {
                        res[i] = -1;
                    }
                    break;
                }
            }
        }

        return res;
    }
}
