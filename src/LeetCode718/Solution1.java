package LeetCode718;

/**
 * 还是不行，暴力破解会Time Limit Exceeded。
 *
 * @author Chanmoey
 * @date 2022年06月03日
 */
public class Solution1 {
    public int findLength(int[] nums1, int[] nums2) {
        int max = 0;
        for (int i = 0; i < nums1.length; i++) {
            int item;
            for (int j = 0; j < nums2.length; j ++) {
                if (nums1[i] == nums2[j]) {
                    item = 1;
                    int p = i + 1;
                    int q = j + 1;
                    while (p < nums1.length && q < nums2.length && nums1[p] == nums2[q]) {
                        item ++;
                        p ++;
                        q ++;
                    }
                    max = Math.max(max, item);
                }
            }
        }

        return max;
    }
}
