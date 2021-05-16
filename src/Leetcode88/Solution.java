package Leetcode88;

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] num = new int[m + n];

        int i = 0, j = 0, index = 0;
        while (i < m && j < n) {
            if (nums1[i] < nums2[j]) {
                num[index++] = nums1[i++];
            } else {
                num[index++] = nums2[j++];
            }
        }

        if (i >= m) {
            while (index < m + n) {
                num[index++] = nums2[j++];
            }
        }

        if (j >= n) {
            while (index < m + n) {
                num[index++] = nums1[i++];
            }
        }

        for (int k = 0; k < num.length; k++) {
            nums1[k] = num[k];
        }

    }
}
